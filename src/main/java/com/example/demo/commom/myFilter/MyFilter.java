package com.example.demo.commom.myFilter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "myFilter",urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String contextPath = request.getContextPath();
        System.out.println("contextPath:"+contextPath);
        String servletPath = request.getServletPath();
        System.out.println("servletPath:"+servletPath);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL:"+requestURL);
        String requestURI = request.getRequestURI();
        System.out.println("requestURI:"+requestURI);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
