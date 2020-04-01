package com.djz.self.modules.basic.rest;

import com.alibaba.fastjson.JSONObject;
import com.djz.self.utils.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/self")
public class HelloController {

	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public Msg<Object> hello(){
		
		return Msg.resultJson(200, "helloWord!","helloWord!");
	}

	@RequestMapping(value="/test1",method=RequestMethod.GET)
	@ResponseBody
	public String hello2(){

		return "HelloWorld";
	}
}
