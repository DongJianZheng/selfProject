package com.djz.self.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/self")
public class HelloController {

	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	@ResponseBody
	public String hello(){
		
		return "HelloWorld";
	}

	@RequestMapping(value="/test1",method=RequestMethod.GET)
	@ResponseBody
	public String hello2(){

		return "HelloWorld";
	}
}
