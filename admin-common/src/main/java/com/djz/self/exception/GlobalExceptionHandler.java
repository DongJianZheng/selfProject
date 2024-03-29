package com.djz.self.exception;


import com.djz.self.utils.DataValidateFiledException;
import com.djz.self.utils.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice//@ControllerAdvice拦截异常
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 所有异常报错
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
	
	//@ExceptionHandler指定处理哪种异常（可指定多个）
    @ExceptionHandler(value= DataValidateFiledException.class)
    public Message<String> allExceptionHandler(HttpServletRequest request,
                                               DataValidateFiledException exception) throws Exception {
    	
    	String string = exception.toString();
    	return Message.ok(string,500);
    	
    }  
}