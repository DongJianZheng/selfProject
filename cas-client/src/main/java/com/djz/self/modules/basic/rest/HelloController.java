package com.djz.self.modules.basic.rest;

import com.alibaba.fastjson.JSONObject;
import com.djz.self.base.controller.BaseController;
import com.djz.self.constant.ResponseCode;
import com.djz.self.modules.basic.domain.User;
import com.djz.self.modules.basic.mapper.UserMapper;
import com.djz.self.modules.basic.service.UserService;
import com.djz.self.utils.Msg;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.common.BaseMapper;

@Controller
@RequestMapping(value="/self")
public class HelloController extends BaseController{


	@Autowired
	private UserService userService;


	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public Msg<Object> hello(){
		//userService.update(new User());
		PageInfo<User> byPage = userService.findByPage(1, 10, new User());
		return Msg.resultJson(ResponseCode.SUCCESS, byPage,"成功");
	}

	@RequestMapping(value="/test1",method=RequestMethod.GET)
	@ResponseBody
	public String hello2(){

		return "HelloWorld";
	}
}
