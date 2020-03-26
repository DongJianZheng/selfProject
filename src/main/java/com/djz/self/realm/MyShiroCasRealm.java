package com.djz.self.realm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.djz.self.domain.basic.Authority;
import com.djz.self.domain.basic.Resource;
import com.djz.self.domain.basic.User;
import com.djz.self.service.AuthorityService;
import com.djz.self.service.ResourceAuthorityService;
import com.djz.self.service.ResourceService;
import com.djz.self.service.UserService;
import com.djz.self.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;


public class MyShiroCasRealm extends CasRealm {

	Boolean cachingEnabled=true;

	@Autowired
	UserService userService;

	@Autowired
	ResourceService resourceService;

	@Autowired
	RedissonClient redissonClient;

	@Autowired
	ResourceAuthorityService resourceAuthorityService;

	@Autowired
	AuthorityService authorityService;
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		CasToken casToken = (CasToken) token;
		if (token == null) {
			return null;
		}

		String ticket = (String)casToken.getCredentials();
		if (!StringUtils.hasText(ticket)) {
			return null;
		}

		TicketValidator ticketValidator = ensureTicketValidator();

		try {
			// contact CAS server to validate service ticket
			Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
			// get principal, user id and attributes
			AttributePrincipal casPrincipal = casAssertion.getPrincipal();
			String userId = casPrincipal.getName();


			Map<String, Object> attributes = casPrincipal.getAttributes();
			// refresh authentication token (user id + remember me)
			casToken.setUserId(userId);
			String rememberMeAttributeName = getRememberMeAttributeName();
			String rememberMeStringValue = (String)attributes.get(rememberMeAttributeName);
			boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
			if (isRemembered) {
				casToken.setRememberMe(true);
			}

			User user = userService.selectByAccount(userId);
			user.setTicket(ticket);
			// create simple authentication info
			List<Object> principals = CollectionUtils.asList(userId, attributes);
			PrincipalCollection principalCollection = new SimplePrincipalCollection(user,"myShiroCasRealm");
			return new SimpleAuthenticationInfo(principalCollection, ticket);
		} catch (TicketValidationException e) {
			throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", e);
		}
	}


	/**
	 * 1.授权方法，在请求需要操作码的接口时会执行此方法。不需要操作码的接口不会执行
	 * 2.实际上是 先执行 AuthorizingRealm，自定义realm的父类中的 getAuthorizationInfo方法，
	 * 逻辑是先判断缓存中是否有用户的授权信息（用户拥有的操作码），如果有 就直返回不调用自定义 realm的授权方法了，
	 * 如果没缓存，再调用自定义realm，去数据库查询。
	 * 用库查询一次过后，如果 在安全管理器中注入了 缓存，授权信息就会自动保存在缓存中，下一次调用需要操作码的接口时，
	 * 就肯定不会再调用自定义realm授权方法了。   网上有分析AuthorizingRealm，shiro使用缓存的过程
	 * 3.AuthorizingRealm 有多个实现类realm，推测可能是把 自定义realm注入了安全管理器，所以才调用自定义的
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();

		User user = (User)principals.getPrimaryPrincipal();
		//这应该把查出来的无序菜单手动放到缓存
		List<Resource> resourceList;
		if(user.getSuperman()){//超管
			resourceList =resourceService.getAll();
			simpleAuthorInfo.addStringPermission("administrator");

			//List list=new ArrayList<>();
			//list.add("ACTUATOR");
			//simpleAuthorInfo.addRoles(list);//actuator监控 后提示需要加这个角色才能访问/beans等端点
		}else{
			resourceList = resourceService.getResourceByUserId(user.getId());
			List<String>resourceIds=new ArrayList<>();
			for(Resource reousrce:resourceList){
				resourceIds.add(reousrce.getId());
			}
			List<String> authorityIds = resourceAuthorityService.getAuthorityByResource(resourceIds);
			List<Authority> authorityList = authorityService.getAuthorityByIds(authorityIds);
			if(org.apache.commons.collections.CollectionUtils.isNotEmpty(authorityIds)){
				for(Authority authority:authorityList){
					simpleAuthorInfo.addStringPermission(authority.getCode());
				}
			}
		}
		if(org.apache.commons.collections.CollectionUtils.isNotEmpty(resourceList)){redissonClient.getMapCache(Constants.REDIS_RESOURCE).put(user.getId(), resourceList);}

		//simpleAuthorInfo.addStringPermission("how_are_you");
		System.out.println("经试验：并不是每次调用接口就会执行，而是调用需要操作码（permission）的接口就会执行");
		return simpleAuthorInfo;
	}
}
