package com.djz.self.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.djz.self.util.Client;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.djz.self.service.ResourceService;
import com.djz.self.util.Constants;
import com.djz.self.util.Message;
import com.djz.self.domain.basic.User;


@Controller
public class LoginController {
	
	@Autowired
	ResourceService resourceService;

	@Value("${shiro.cas}")
	private String casServer;

	@Value("${shiro.server}")
	private String server;

	@RequestMapping(value="/self/login")
	@ResponseBody
	public Message<String> userLogin(User user,HttpServletRequest request){
		if(user==null){
			//return "login";
			return Message.ok("登录失败");
		}
		String serviceTicket = request.getParameter("ticket");
		String ticketGrantingTicket ="";
		if(StringUtils.isEmpty(serviceTicket)){
			String account=user.getLoginName();
			String password=user.getPassword();

			ticketGrantingTicket = Client.getTicketGrantingTicket(casServer + "/v1/tickets", account, password);
			serviceTicket= Client.getServiceTicket(casServer + "/v1/tickets",ticketGrantingTicket ,server+"/self") ;

		}

		CasToken casToken = new CasToken(serviceTicket);

		Subject currentUser = SecurityUtils.getSubject();
		try {
			casToken.setRememberMe(false);
			currentUser.login(casToken);

			System.out.println(casToken.getCredentials().getClass());
			//此步将 调用realm的认证方法
		} catch(IncorrectCredentialsException e){
			//这最好把 所有的 异常类型都背会
			//model.addAttribute("message", "密码错误");
			return Message.ok("密码错误");
		} catch (AuthenticationException e) {
			//model.addAttribute("message", "登录失败");
			return Message.ok("登录失败");
		}
		request.setAttribute("name", "test");
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length ; i++) {
			System.out.println(cookies[i].getName()+"-"+cookies[i].getValue());
		}
		return Message.ok("http://127.0.0.1:8085/self/test?ticket="+serviceTicket );
	}
	
	//配合shiro配置中的默认访问url
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLogin(HttpServletRequest request,Model model,HttpSession session,HttpServletResponse response){

		return "login";
	}
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		System.out.println("访问了后端 /  请求");
		return "login";
	}
	
	/**
	* 退出
	 * @return
	 */
	@RequestMapping(value="/self/logout",method =RequestMethod.GET)
	@ResponseBody
	public String logout(HttpServletRequest request){
		

		try {

			//"/cas/p3/serviceValidate?service={service url}&ticket={service ticket}"

			Session session = SecurityUtils.getSubject().getSession();

			//退出
            Subject lvSubject=SecurityUtils.getSubject();
			Object principal = lvSubject.getPrincipal();
			User user =(User)principal;

			//http://95.169.6.84:8088/cas/proxyValidate?ticket=ST-77-xGbvYPdL7Bi7b7ZJaFWK-95.169.6.84&service=http://127.0.0.1:8085/self
			Client.ticketValidate(casServer + "/proxyValidate", user.getTicket(), server+"/self");
			//lvSubject.logout();



		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return "1";
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
