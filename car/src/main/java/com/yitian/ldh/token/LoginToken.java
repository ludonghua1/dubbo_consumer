package com.yitian.ldh.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class LoginToken extends UsernamePasswordToken {
    private String validate;

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public LoginToken(String username, String password, boolean rememberMe, String validate) {
        super(username, password, rememberMe);
        this.validate = validate;
    }
}
