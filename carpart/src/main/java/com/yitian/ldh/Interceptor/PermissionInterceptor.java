package com.yitian.ldh.Interceptor;

import com.yitian.ldh.model.Menu;
import com.yitian.ldh.model.User;
import com.yitian.ldh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestPath = httpServletRequest.getRequestURI();
        if (requestPath.contains("/login")){
            return true;
        }else {
            HttpSession session = httpServletRequest.getSession(false);
            if (session==null){
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/toLogin.shtml");
                return false;
            }else {
                if (session.getAttribute("user")!=null){
                    User user = (User) session.getAttribute("user");
                    List<Menu> menuList = userService.findMenuByUser(user);
                    String key = requestPath.substring(0,requestPath.lastIndexOf("/"));
                    key = key.substring(key.lastIndexOf("/"));
                    Boolean check = false;
                    for (Menu menu:menuList){
                        if (menu.getUrl().contains(key)){
                            check = true;
                            break;
                        }
                    }
                    if (check){
                        return true;
                    }else {
                        //
                        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/nu.shtml");
                        return false;
                    }
                }else {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login/toLogin.shtml");
                    return  false;
                }
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
