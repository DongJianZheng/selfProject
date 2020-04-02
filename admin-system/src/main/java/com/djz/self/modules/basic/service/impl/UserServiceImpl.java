package com.djz.self.modules.basic.service.impl;


import com.djz.self.base.service.impl.BaseServiceImpl;
import com.djz.self.modules.basic.domain.User;
import com.djz.self.modules.basic.mapper.UserMapper;
import com.djz.self.modules.basic.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author djz
 * @createTime 2020-04-01
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper,User> implements UserService  {


}
