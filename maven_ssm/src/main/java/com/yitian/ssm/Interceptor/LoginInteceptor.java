package com.yitian.ssm.Interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.JedisCluster;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInteceptor implements HandlerInterceptor {
    @Autowired
    private JedisCluster jedisCluster;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setCharacterEncoding("utf-8");
        String path = httpServletRequest.getRequestURI();
        if (path.contains("login")||path.contains("toLogin")){
            return true;
        }else {
        //获取cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        String token ="";
            //遍历cookie
            for (Cookie cookie:cookies){
                //System.out.println(cookie.getName());
                //判断cookie的key值是否相等，
                if (cookie.getName().equals("login")){
                    //如果相等，取出cookie对应的值,赋给token
                    token=cookie.getValue();
                    //跳出循环
                    break;
                }
            }
            //判断集群里是否存在token，如果存在，放行
            if (jedisCluster.exists(token)){
                return true;
            }else {
                //重定向到登录页面
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/toLogin.shtml");
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        httpServletRequest.setAttribute("path",httpServletRequest.getContextPath());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
