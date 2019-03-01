package com.djz.self.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djz.self.util.Asserts;
import com.djz.self.util.DataValidateFiledException;
import com.djz.self.domain.basic.UserRoleR;
import com.djz.self.domain.vm.UserRoleSaveVM;
import com.djz.self.domain.vm.UserRoleSaveVMS;
import com.djz.self.mapper.basic.UserRoleRMapper;
import com.djz.self.mapper.extend.UserRoleRExtendMapper;

@Service
@Transactional
public class UserRoleService {

	@Autowired
	UserRoleRExtendMapper userRoleRExtendMapper;
	
	@Autowired
	UserRoleRMapper userRoleRMapper;
	
	/**
	 * 给用户授权
	 * 单个用户
	 * @param userRoleVMS
	 */
	public void delegate(UserRoleSaveVMS userRoleVMS) {
		Asserts.validate(userRoleVMS, "userRole");
		
		String userId=userRoleVMS.getUserId();
		List<String> roleList = Arrays.asList(userRoleVMS.getRoleIds().split(","));
		List<UserRoleR> userRoleList=new ArrayList<UserRoleR>();
		List<String> userIdList=new ArrayList<String>();
		for(String roleId:roleList){
			UserRoleR userRole=new UserRoleR();
			userRole.setId(UUID.randomUUID().toString());
			userRole.setUserId(userId);
			userRole.setRoleId(roleId);
			userRoleList.add(userRole);
			userIdList.add(userRole.getUserId());
		}
		
		//先删再增
		userRoleRExtendMapper.deleteByUserId(userIdList);
		userRoleRExtendMapper.batchInsert(userRoleList);
	}
	
	/**
	 * 根据用户id 删除用户角色关系
	 */
	public void deleteByUserId(String userId){
		if(StringUtils.isBlank(userId)){throw new DataValidateFiledException("用户Id不能为空");}
		
		List <String>userIdList=new ArrayList<String>();
		userIdList.add(userId);
		userRoleRExtendMapper.deleteByUserId(userIdList);
	}
	
	/**
	 * 根据角色id删除用户角色关系
	 */
	public void deleteByRoleId(String roleId){
		if(StringUtils.isBlank(roleId)){throw new DataValidateFiledException("角色Id不能为空");}
		
		userRoleRExtendMapper.deleteByRoleId(roleId);
	}
	
	/**
	 * 根据‘用户id查所拥有的角色e
	 */
	public List<String> getRoleByUser(String userId){
		Asserts.notEmpty(userId);
		List<String> roleIds = userRoleRExtendMapper.getRoleByUser(userId);
		return roleIds;
	}
}
