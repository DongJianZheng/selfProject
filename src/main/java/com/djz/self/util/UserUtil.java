package com.djz.self.util;

import com.alibaba.fastjson.JSONObject;
import com.djz.self.domain.basic.User;
import org.springframework.util.StringUtils;

public class UserUtil {

    public static JSONObject getResultUserInfo(User user){


        JSONObject jsonObject = new JSONObject();
        if(!StringUtils.isEmpty(user)){
            jsonObject.put("loginName",user.getLoginName());
            jsonObject.put("realName",user.getRealName());
            jsonObject.put("ticket",user.getTicket());
            jsonObject.put("superman",user.getSuperman());
        }
        return  jsonObject;
    }

}
