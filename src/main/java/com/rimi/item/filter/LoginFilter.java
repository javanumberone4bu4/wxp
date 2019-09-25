package com.rimi.item.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 13:54
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 获取当前的请求路径
        String uri = request.getRequestURI();
        // 判断请求的路径中是否包含需要放行的地址
        if (uri.contains("/css/") || uri.contains("/js/") ||
                uri.contains("/fonts/") || uri.contains("/error/") ||
                uri.contains("login.jsp") || uri.contains("/login")) {
            chain.doFilter(req, resp);
        } else {
            // 1.获取session的用户
            HttpSession session = request.getSession();
            Object username = session.getAttribute("username");
            if (username == null) {
                // 2.1如果没有获取到,则重定向到登陆页面
                response.sendRedirect(request.getContextPath() + "/login");
            } else {
                // 2.2如果获取到了,则放行
                chain.doFilter(req, resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
