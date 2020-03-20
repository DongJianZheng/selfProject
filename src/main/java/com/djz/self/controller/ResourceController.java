package com.djz.self.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.djz.self.service.ResourceAuthorityService;
import com.djz.self.service.ResourceService;
import com.djz.self.util.Constants;
import com.djz.self.util.Message;
import com.djz.self.domain.basic.Authority;
import com.djz.self.domain.vm.ResourceSaveVM;
import com.djz.self.domain.vm.ResourceUpdateVM;
import com.djz.self.domain.vm.ResourceVM;


@RestController
public class ResourceController {
	
	@Autowired
	ResourceService resourceService;
	
	@Autowired
	ResourceAuthorityService resourceAuthorityService;

	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header")
	})
	@ApiOperation(value="新增资源",notes="新增资源，需要resource_addResource权限或管理员权限")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@RequiresPermissions(value={"resource_addResource","administrator"},logical=Logical.OR)
	@RequestMapping(value="/self/resource",method=RequestMethod.POST)
	public Message<String> addResource(ResourceSaveVM resourceSaveVM){
		resourceService.addResource(resourceSaveVM);
		return Message.ok(Constants.SUCCESS);
	}
	
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header")
	})
	@ApiOperation(value="修改资源",notes="修改资源，需要resource_updateResource权限或管理员权限")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@RequiresPermissions(value={"resource_updateResource","administrator"},logical=Logical.OR)
	@RequestMapping(value="/self/resouce",method=RequestMethod.PUT)
	public Message<String> updateResource( ResourceUpdateVM resourceUpdateVM){
		resourceService.updateResource(resourceUpdateVM);
		return Message.ok(Constants.SUCCESS);
	}
	
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header")
	})
	@ApiOperation(value="删除资源",notes="删除资源，需要resource_deleteResource权限或管理员权限")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@RequiresPermissions(value={"resource_deleteResource","administrator"},logical=Logical.OR)
	@RequestMapping(value="/self/resource/{resourceId}",method=RequestMethod.DELETE)
	public Message<String> deleteResource(@PathVariable(value="resourceId")String resourceId){
		resourceService.deleteResource(resourceId);
		return Message.ok(Constants.SUCCESS);
	}
	
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header")
	})
	@ApiOperation(value="查询资源列表",notes="查询资源列表，需要resource_getAllResource权限或管理员权限")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@RequiresPermissions(value={"resource_getAllResource","administrator"},logical=Logical.OR)
	@RequestMapping(value="/self/resource",method=RequestMethod.GET)
	public Message<List<ResourceVM>>getAllResource(){
		List<ResourceVM> resouceList=resourceService.getAllResource();
		return Message.ok(resouceList);
	}
	
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header")
	})
	@ApiOperation(value="查询当前登录用户的资源树",notes="查询当前登录用户的资源树，需要resource_getCurrentUserResourceTree权限或管理员权限")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	//@RequiresPermissions(value={"resource_getCurrentUserResourceTree","administrator"},logical=Logical.OR)
	@RequestMapping(value="/self/resource/getCurrentUserResourceTree",method=RequestMethod.GET)
	public Message<List<ResourceVM>>getCurrentUserResourceTree(){
		List<ResourceVM> list=resourceService.getCurrentUserResourceTree();
		return Message.ok(list);
	}
	
	
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header")
	})
	@ApiOperation(value="查单个资源 拥有的操作码",notes="查单个资源 拥有的操作码，需要resource_getAuthorityByResource权限或管理员权限")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@RequiresPermissions(value={"resource_getAuthorityByResource","administrator"},logical=Logical.OR)
	@RequestMapping(value="/self/resource/getAuthorityByResource",method=RequestMethod.GET)
	public Message<List<Authority>>getAuthorityByResource(@RequestParam(value="ResourceId")String ResourceId){
		List<Authority> list=resourceAuthorityService.getAuthorityByResource(ResourceId);
		return Message.ok(list);
	}
	
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header"),
		@ApiImplicitParam(name = "resourceId", value = "resourceId", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "authorityId", value = "authorityId，如果为null，则取消资源的所有权限"
		,required=false, dataType = "string", paramType = "query")
	})
	@ApiOperation(value="取消授权,取消一个资源的某个 或一些 权限",notes="取消授权，需要resource_deleteResourceAuthority权限或管理员权限")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@RequiresPermissions(value={"resource_deleteResourceAuthority","administrator"},logical=Logical.OR)
	@RequestMapping(value="/self/resource/deleteResourceAuthority",method=RequestMethod.POST)
	public Message<String>deleteResourceAuthority(@RequestParam(value="resourceId")String resourceId,@RequestParam(value="authorityId")String authorityId){
		resourceAuthorityService.deleteResourceAuthority(resourceId,authorityId);
		return Message.ok(Constants.SUCCESS);
	}
	
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "Authorization", value = "token", dataType = "string", paramType = "header")
	})
	@ApiOperation(value="给资源授权,单个操作码给单个资源",notes="给资源授权，需要resource_authorize权限或管理员权限")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success") })
	@RequiresPermissions(value={"resource_authorize","administrator"},logical=Logical.OR)
	@RequestMapping(value="/self/resource/authorize",method=RequestMethod.POST)
	public Message<String> authorize(@RequestParam(value="resourceId")String resourceId,@RequestParam(value="authorityId")String authorityId){
		resourceAuthorityService.authorize(resourceId,authorityId);
		return Message.ok(Constants.SUCCESS);
	}
}
