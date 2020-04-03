package com.djz.self.security.realm;

import java.util.List;
import java.util.Map;
import com.djz.self.modules.basic.domain.User;
import com.djz.self.modules.basic.service.UserService;
import com.djz.self.security.cas.MyCasToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;


public class MyShiroCasRealm extends CasRealm {


	@Autowired
	private UserService userService;


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		MyCasToken casToken = (MyCasToken) token;
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

			User user = new User();
			user.setUserName(userId);
			User sysUser = new User();
			sysUser = userService.selectOne(user);
			// create simple authentication info
			List<Object> principals = CollectionUtils.asList(userId, attributes);
			if(StringUtils.isEmpty(sysUser)){
				sysUser = user;
			}
			PrincipalCollection principalCollection = new SimplePrincipalCollection(sysUser,"myShiroCasRealm");
			return new SimpleAuthenticationInfo(principalCollection, ticket);
		} catch (TicketValidationException e) {
			throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", e);
		}
	}



}
