package com.djz.self.modules.basic.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.djz.self.constant.ResponseCode;
import com.djz.self.modules.basic.domain.User;
import com.djz.self.modules.basic.domain.vo.UserVo;
import com.djz.self.modules.basic.service.UserService;
import com.djz.self.security.cas.MyCasToken;
import com.djz.self.session.CasLogoutFilter;
import com.djz.self.session.HashMapBackedSessionMappingStorage;
import com.djz.self.session.SingleSignOutHandler;
import com.djz.self.utils.Client;
import com.djz.self.utils.Msg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class LoginController {

	@Value("${shiro.cas}")
	private String casServer;

	@Value("${shiro.server}")
	private String server;


	@RequestMapping(value="/self/login")
	@ResponseBody
	public Msg<Object> userLogin(@RequestBody User user, HttpServletRequest request){
		if(user==null){
			//return "login";
			Msg.resultJson(ResponseCode.NO_AUTH,SecurityUtils.getSubject().getPrincipal(),"登录失败");
		}
		String serviceTicket = request.getParameter("ticket");
		String ticketGrantingTicket ="";

		String account=user.getUserName();
		String password=user.getPassword();

		ticketGrantingTicket = Client.getTicketGrantingTicket(casServer + "/v1/tickets", account, password);

		serviceTicket= Client.getServiceTicket(casServer + "/v1/tickets",ticketGrantingTicket ,server+"/self") ;


		MyCasToken casToken = new MyCasToken(serviceTicket);

		Subject currentUser = SecurityUtils.getSubject();
		UserVo cUser = null;
		try {
			casToken.setRememberMe(false);
			casToken.setTGT(ticketGrantingTicket);
			currentUser.login(casToken);

			cUser = (UserVo)SecurityUtils.getSubject().getPrincipal();

			//此步将 调用realm的认证方法
		} catch(Exception e){
			//model.addAttribute("message", "登录失败");
			e.printStackTrace();
			return Msg.resultJson(ResponseCode.NO_AUTH ,e.getMessage(),"登录失败");
		}

		if(StringUtils.isEmpty(cUser)){
			return Msg.resultJson(ResponseCode.ERROR, cUser,"用户名或密码错误");
		}
		CasLogoutFilter.getSingleSignOutHandler().recordSession(serviceTicket);
		return  Msg.resultJson(ResponseCode.SUCCESS, cUser,"登录成功");
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

		UserVo user =null;
		try {


			//退出
            Subject lvSubject=SecurityUtils.getSubject();
			Object principal = lvSubject.getPrincipal();

			user =(UserVo)principal;
			Client.deleteTicketGrantingTicket(casServer + "/v1/tickets"+"/"+user.getTGT());
			lvSubject.logout();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		 return  Msg.resultJson(200, user,"退出成功");
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
