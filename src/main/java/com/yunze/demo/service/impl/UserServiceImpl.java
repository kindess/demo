package com.yunze.demo.service.impl;
import com.yunze.demo.constant.ErrorMsg;
import com.yunze.demo.exception.CustomException;
import com.yunze.demo.mapper.UserMapper;
import com.yunze.demo.pojo.User;
import com.yunze.demo.service.UserService;
import com.yunze.demo.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    // 运行时能够根据类型正确自动注入
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户id或者用户名查询用户
     * @param user
     * @return
     */
    @Override
    public User queryUserByIdOrUsername(User user){
        User result = null;
        if (user != null){
            // 如果id不为空，根据id查询
            if (!StringUtils.isEmpty(user.getId())){
                result = userMapper.getUserById(user.getId());
            }
            // 如果用户名不为空，通过用户名查询
            if (!StringUtils.isEmpty(user.getUsername())){
                result = userMapper.getUserByUsername(user.getUsername());
            }
        }
        return result;
    }

    /**
     * 登录测试
     * @param user
     * @return
     */
    @Override
    public ResultCode<String> login(User user) throws CustomException {
        int statusCode = 200;
        String message = "登录成功";
        String data = "";
        User result = queryUserByIdOrUsername(user);
        // 1、用户名或者密码错误
        if (result == null
                || (!StringUtils.isEmpty(result.getPassword())
                    &&! result.getPassword().equals(user.getPassword()))){
            throw new CustomException(ErrorMsg.ERROR_100004);
        }
        // 2、登录成功
        return new ResultCode<String>(statusCode,message,data);
    }
}
