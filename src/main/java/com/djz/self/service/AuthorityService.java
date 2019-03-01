package com.djz.self.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djz.self.util.Asserts;
import com.djz.self.util.EntityUtils;
import com.djz.self.domain.basic.Authority;
import com.djz.self.domain.extend.AuthorityController;
import com.djz.self.domain.vm.AuthoritySaveVM;
import com.djz.self.domain.vm.AuthorityUpdateVM;
import com.djz.self.domain.vm.AuthorityVMS;
import com.djz.self.mapper.basic.AuthorityMapper;
import com.djz.self.mapper.extend.AuthorityExtendMapper;

@Service
@Transactional
public class AuthorityService {

	@Autowired
	AuthorityExtendMapper authorityExtendMapper;
	
	@Autowired
	AuthorityMapper authorityMapper;
	
	@Autowired
	ResourceAuthorityService resourceAuthorityService;
	
	
	/**
	 * 根据 权限id 查权限对象集
	 */
	public List<Authority> getAuthorityByIds(List<String> ids){
		if(CollectionUtils.isEmpty(ids)){return null;}
		return authorityExtendMapper.getAuthorityByIds(ids);
	}


	/**
	 * 按controller分组，得到authority列表
	 * @return
	 */
	public List<AuthorityVMS> getAuthority() {
		List<AuthorityController> authorityList = authorityExtendMapper.getAuthority();
		return EntityUtils.entity2VMList(authorityList, AuthorityVMS.class);
	}


	public List<Authority> getLikeAuthority(String method, String word) {
		Asserts.notEmpty(method);
		return authorityExtendMapper.getLikeAuthority(method, word);
	}


	public void saveAuthority(AuthoritySaveVM authoritySaveVM) {
		Asserts.validate(authoritySaveVM,"authoritySaveVM");
		Authority authority = EntityUtils.entity2VM(authoritySaveVM, Authority.class);
		authority.setId(UUID.randomUUID().toString());
		authorityMapper.insert(authority);
	}


	public void updateAuhtority(AuthorityUpdateVM authorityUpdateVM) {
		Asserts.validate(authorityUpdateVM, "authorityUpdateVM");
		//校验id是否存在
		
		Authority authority = EntityUtils.vm2Entity(authorityUpdateVM, Authority.class);
		authorityMapper.updateByPrimaryKey(authority);
	}


	public void deleteAuthority(String id) {
		Asserts.notEmpty(id);
		
		//删除资源权限关系
		resourceAuthorityService.deleteResourceAuthority(null,id);
		
		//删除权限
		authorityMapper.deleteByPrimaryKey(id);
	}



	
}
