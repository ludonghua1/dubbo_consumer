package com.yitian.ldh.servlet;

import com.yitian.ldh.util.ImageUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login/Kaptcha.jpg")
public class Kaptcha extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	        response.setContentType("image/jpeg");  
	          
	        //��������ִ�  
	        String verifyCode = ImageUtil.generateVerifyCode(4);
	        Session session = SecurityUtils.getSubject().getSession();
	        session.setAttribute("validate", verifyCode.toUpperCase());
	        //����ͼƬ  
	        int w = 200, h = 80;  
	        ImageUtil.outputImage(w, h, response.getOutputStream(), verifyCode);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
