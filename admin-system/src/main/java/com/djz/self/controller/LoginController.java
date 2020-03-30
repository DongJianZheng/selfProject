package com.djz.self.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.djz.self.entity.basic.User;
import com.djz.self.util.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class LoginController {

	@Value("${shiro.cas}")
	private String casServer;

	@Value("${shiro.server}")
	private String server;

	@RequestMapping(value="/self/login")
	@ResponseBody
	public Msg<Object> userLogin(User user, HttpServletRequest request){
		if(user==null){
			//return "login";
			Msg.resultJson(401,SecurityUtils.getSubject().getPrincipal(),"登录失败");
		}
		String serviceTicket = request.getParameter("ticket");
		String ticketGrantingTicket ="";

		String account=user.getUserName();
		String password=user.getPassword();

		ticketGrantingTicket = Client.getTicketGrantingTicket(casServer + "/v1/tickets", account, password);

		serviceTicket= Client.getServiceTicket(casServer + "/v1/tickets",ticketGrantingTicket ,server+"/self") ;



		CasToken casToken = new CasToken(serviceTicket);

		Subject currentUser = SecurityUtils.getSubject();
		User cUser = null;
		try {
			casToken.setRememberMe(false);
			currentUser.login(casToken);

			cUser = (User)SecurityUtils.getSubject().getPrincipal();


			//此步将 调用realm的认证方法
		} catch(Exception e){
			//model.addAttribute("message", "登录失败");
			Msg.resultJson(401, UserUtil.getResultUserInfo(cUser),"登录失败");
		}

		if(StringUtils.isEmpty(cUser)){
			return Msg.resultJson(500,UserUtil.getResultUserInfo(cUser),"用户名或密码错误");
		}
		return  Msg.resultJson(200,UserUtil.getResultUserInfo(cUser),"登录成功");
	}
	
	//配合shiro配置中的默认访问url
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLogin(HttpServletRequest request,Model model,HttpSession session,HttpServletResponse response){
		return "login";
	}
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public String index(){
		return "login";
	}
	
	/**
	* 退出
	 * @return
	 */
	@RequestMapping(value="/self/logout",method =RequestMethod.GET)
	@ResponseBody
	public Msg<Object> logout(HttpServletRequest request){

		User user =null;
		try {
			//退出
            Subject lvSubject=SecurityUtils.getSubject();
			Object principal = lvSubject.getPrincipal();
			user =(User)principal;
			lvSubject.logout();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		 return  Msg.resultJson(200,UserUtil.getResultUserInfo(user),"退出成功");
	}
	
	@RequestMapping(value="403",method=RequestMethod.GET)
	public String unAuth(){
		
		return "403";
	}

	//配合shiro配置中的默认访问url
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String getHome(HttpServletRequest request,Model model,HttpSession session,HttpServletResponse response){

		return "homm";
	}



}
