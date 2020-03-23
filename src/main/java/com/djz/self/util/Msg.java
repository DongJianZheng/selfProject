package com.djz.self.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

public class Msg {


	public static JSONObject resultJson(Integer code  ,Object data,String msg){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code",code);
		if(StringUtils.isEmpty(data)){
			data = new JSONObject();;
		}
		jsonObject.put("data", data);
		jsonObject.put("msg",msg);
		return jsonObject;
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


}
