package com.shf.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author:Su HangFei
 * @Date:2023-01-01 17 58
 * @Project:boot-05-web-admin
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter工作");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
