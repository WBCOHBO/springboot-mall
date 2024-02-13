package com.bocheng.springbootmall.service.impl;

import com.bocheng.springbootmall.dao.UserDao;
import com.bocheng.springbootmall.dto.UserRegisterRequest;
import com.bocheng.springbootmall.model.User;
import com.bocheng.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {


        return userDao.createUser(userRegisterRequest);
    }
}
