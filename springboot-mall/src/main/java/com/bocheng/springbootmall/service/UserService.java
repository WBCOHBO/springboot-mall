package com.bocheng.springbootmall.service;

import com.bocheng.springbootmall.dto.UserLoginRequest;
import com.bocheng.springbootmall.dto.UserRegisterRequest;
import com.bocheng.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
