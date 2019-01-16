package com.yitian.ldh.webservice.soap;

import com.yitian.ldh.dao.UserMapper;
import com.yitian.ldh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

//2.编写WebService实现类
//注意：如果方法的参数或返回值是对象，那么该类必须得实现序列化接口
@WebService
@Service
public class UserWebServiceImpl implements UserWebService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByLoginName(String loginName) {
        return userMapper.findUserByUser(loginName);
    }
}
