package com.yitian;


import com.yitian.ldh.webservice.soap.User;
import com.yitian.ldh.webservice.soap.UserWebServiceImpl;
import com.yitian.ldh.webservice.soap.UserWebServiceImplService;

public class Test {
    public static void main(String[] args) {
        UserWebServiceImplService factory = new UserWebServiceImplService();
        UserWebServiceImpl userWebService = factory.getUserWebServiceImplPort();
        User user = userWebService.findUserByLoginName("admin");
        System.out.println(user.getPassword());
    }
}
