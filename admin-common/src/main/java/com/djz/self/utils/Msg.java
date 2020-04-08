package com.djz.self.utils;

import com.alibaba.fastjson.JSONObject;
import com.djz.self.constant.ResponseCode;
import org.springframework.util.StringUtils;

public class Msg<T> {


	private Integer code;

	private T data;

	private String msg;
	public Msg() {
	}

	public Msg(Integer code ,T data){
		this.code = code;
		this.data=data;
		this.msg = "执行成功";
	}

	public Msg(T data) {
		this.code = 200;
		this.data = data;
		this.msg = "执行成功";
	}
	public Msg(Integer code ,T data ,String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public static Msg resultJson(Integer code  ,Object data,String msg){
		if(StringUtils.isEmpty(data)){
			data = new JSONObject();;
		}
		return new Msg<Object>(code,data,msg);
	}

	public static String resultString(Integer code  ,Object data,String msg){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code",code);

		if(StringUtils.isEmpty(data)){
			data = new JSONObject();;
		}
		jsonObject.put("data", JSONObject.toJSON(data));
		jsonObject.put("msg",msg);
		return jsonObject.toJSONString();
	}

	public static Msg ok(Object data){
		if(StringUtils.isEmpty(data)){
			data = new JSONObject();;
		}
		return new Msg<Object>(ResponseCode.SUCCESS,data,"成功");
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
