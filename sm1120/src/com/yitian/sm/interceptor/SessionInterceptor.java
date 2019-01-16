package com.yitian.sm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor implements HandlerInterceptor {
    @Override
    //请求进入处理器之前，拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //1.取到目标资源路径
        String path = request.getRequestURI();
        //2.判断目标路径是不是需要被拦截的路径
        if (path.contains("toLogin")||path.contains("login")){
            return true;
        }else {
            //取到当前请求对应的session对象，如果取不到直接返回null，不用帮我创建。
            HttpSession session = request.getSession(false);
            if (session==null){
                response.sendRedirect(request.getContextPath()+"/toLogin.action");
                return false;
            }else {
                if (session.getAttribute("user")!=null){
                    return true;
                }else {
                    response.sendRedirect(request.getContextPath()+"/toLogin.action");
                    return false;
                }
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
                request.setAttribute("path",request.getContextPath());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
