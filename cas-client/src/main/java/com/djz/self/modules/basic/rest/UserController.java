package com.djz.self.modules.basic.rest;

import com.djz.self.base.controller.BaseController;
import com.djz.self.modules.basic.domain.User;
import com.djz.self.modules.basic.mapper.UserMapper;
import com.djz.self.utils.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/self/user")
public class UserController extends BaseController{


}
