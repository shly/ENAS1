package com.neusoft.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthenticationFilter implements javax.servlet.Filter{
	
	private static String LOGIN_PAGE = "/index.jsp";  
	private static String FORBIDDEN_PAGE = "/common/500.jsp";
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;  
		  
        HttpServletResponse res = (HttpServletResponse) response;  
  
        // 当前访问路径   
        String currentUrl = req.getRequestURI();  
        // 获取session   
        HttpSession session = req.getSession();   

        if(currentUrl.endsWith("userAction.login.action") || currentUrl.endsWith("index.jsp") || currentUrl.endsWith("ENAS1/")){
    		chain.doFilter(request, response); 
    	}else{
			if (session == null || session.getAttribute("current_user") == null) {
				res.sendRedirect(req.getContextPath() + LOGIN_PAGE);
			}else{
				String current_user = (String) session.getAttribute("current_user");
				if (!"login_success".equals(session.getAttribute(current_user))) {
					res.sendRedirect(req.getContextPath() + LOGIN_PAGE);
				}else{
					chain.doFilter(request, response);
				}
			}
    	}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}

