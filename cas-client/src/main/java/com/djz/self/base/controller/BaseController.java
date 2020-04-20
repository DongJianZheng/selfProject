package com.djz.self.base.controller;

import com.alibaba.fastjson.JSONArray;

import com.djz.self.base.entity.BaseEntity;
import com.djz.self.base.service.BaseService;
import com.djz.self.modules.basic.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import tk.mybatis.mapper.common.BaseMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class BaseController  extends ApplicationObjectSupport {

    public Logger log = LoggerFactory.getLogger(this.getClass());


    private static  final String models="models";





    /**
     *要跳转的页面
     * @author: djz
     * @param path
     * @Return
     * @date:  2020-04-03 11:15
     */
    protected ModelAndView go(String path) {
        return new ModelAndView(path);
    }

    /**
     * 到bean信息
     * @param name
     * @return
     */
    protected Object getObject(String name) {
        return this.getApplicationContext().getBean(name);
    }

    /**
     * 获取登录用户信息
     * @return User
     */
    public User getUserSessionVo() {
        Subject subject = SecurityUtils.getSubject();
        Object obj = null;//subject.getSession().getAttribute(UserAuthenticationRealm.LOGIN_SESSION_ATTR);
        if (obj instanceof User) {
            return (User) obj;
        }
        return null;
    }


    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public HttpSession getSession() {
        return getRequest().getSession();
    }

    public HttpServletResponse getResponse() {
        return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取国际化信息
     *
     * @param key
     * @return
     */
    public String getI18nMsg(String key) throws Exception {
        // 从后台代码获取国际化信息
        String value = new RequestContext(this.getRequest()).getMessage(key);
        return value != null ? value : "";
    }

    /**
     * 返回国际化国家标识串
     *
     * @return
     * @throws Exception
     */
    public String getI18nCountry() throws Exception {
        String lc = null;
        RequestContext requestContext = new RequestContext(this.getRequest());
        String language = requestContext.getLocale().getLanguage();
        String country = requestContext.getLocale().getCountry();
        if (country == null || "".equals(country)) {
            if ("zh".equals(language)) {
                country = "CN";
            } else if ("en".equals(language)) {
                country = "US";
            }
        }
        // logger.debug("本地国际化语言：" + language + "本地国际化国家：" + country);
        lc = "_" + language + (StringUtils.isEmpty(country) ? "" : "_" + country);
        return lc;
    }

    /**
     * 请求方式判断
     *
     * @param request
     * @return
     */
    public boolean isAjaxRequest(HttpServletRequest request) {
        if (!(request.getHeader("accept").indexOf("application/json") > -1
                || (request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)
                || "XMLHttpRequest".equalsIgnoreCase(request.getParameter("X_REQUESTED_WITH")))) {
            return false;
        }
        return true;
    }
    /**
     * 保存信息到request中
     *
     * @param key
     * @param value
     */
    public void setRequestAttribute(String key, Object value) {
        this.getRequest().setAttribute(key, value);
    }

    protected String getCookie(String cookieName) {
        Cookie[] cookies = getRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        return null;
    }

    /**
     * 设置 cookie
     *
     * @param cookieName
     * @param value
     * @param age
     */
    protected void setCookie(String cookieName, String value, int age) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setMaxAge(age);
        // cookie.setHttpOnly(true);
        getResponse().addCookie(cookie);
    }



    /**
     * 方法名称: render<br>
     * 描述：返回给浏览器
     */
    public void render(String text, String contentType){
        HttpServletResponse response;
        try{
            response = getResponse();
            response.setContentType(contentType);
            response.getWriter().write(text);
            response.getWriter().flush();
        }
        catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 方法名称: renderText<br>
     * 描述：返回普通文本浏览器
     */
    public void renderText(String text){
        render(text, "text/plain;charset=UTF-8");
    }

    /**
     * 方法名称: renderJson<br>
     * 描述：返回JSON格式数据
     */
    public void renderJson(String text){
        render(text,"text/json;charset=UTF-8");
    }


    /**
     * 方法名称: getUUID<br>
     * 描述：获得唯一标识(目前用于验证表单提交唯一性)<br>
     * 作者: <br>
     * 修改日期：2014年10月13日上午3:15:24<br>
     */
    protected String getUUID() {
        return UUID.randomUUID().toString();
    }
}