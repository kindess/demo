package com.yunze.demo.service;

import com.yunze.demo.exception.CustomException;
import com.yunze.demo.pojo.User;
import com.yunze.demo.util.ResultCode;

public interface UserService {
    User queryUserByIdOrUsername(User user);

    /**
     * 登录测试
     * @param user
     * @return
     */
    ResultCode<String> login(User user) throws CustomException;
}