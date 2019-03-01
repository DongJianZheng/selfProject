package com.djz.self.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.djz.self.domain.basic.Resource;

@Mapper
public interface ResourceAuthorityExtendMapper {

	/**
	 * 根据参数资源 查出其拥有的 权限ids
	 */
	List<String> getAuthorityByResource(@Param(value="resourceList")List<String> resourceList);

	/**
	 * 取消授权
	 * @param resourceId
	 * @param authorityId
	 */
	void deleteResourceAuthority(
			@Param(value="resourceId")String resourceId,
			@Param(value="authorityId")String authorityId);
	
}
