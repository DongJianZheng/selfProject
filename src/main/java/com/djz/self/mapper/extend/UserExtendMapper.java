package com.djz.self.mapper.extend;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.djz.self.domain.basic.User;


@Mapper
public interface UserExtendMapper {

	User selectByName(@Param(value="account")String account);
	
	/**
	 * 校验用户名唯一,账号
	 */
	Integer isExist(@Param(value="loginName")String loginName);
}
