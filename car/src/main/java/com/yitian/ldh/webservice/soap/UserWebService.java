package com.yitian.ldh.webservice.soap;


import com.yitian.ldh.model.User;

import javax.jws.WebService;
//声明一个WebService接口
@WebService
public interface UserWebService {
    User findUserByLoginName( String loginName);
}
