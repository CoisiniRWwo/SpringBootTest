package com.shf.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shf.boot.bean.User;
import com.shf.boot.mapper.UserMapper;
import com.shf.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author:Su HangFei
 * @Date:2023-01-04 16 14
 * @Project:boot-05-web-admin
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
