package com.rimi.item.servlet;

import com.rimi.item.common.BaseServlet;
import com.rimi.item.common.ErrorConstant;
import com.rimi.item.common.LoginConstant;
import com.rimi.item.service.ILoginService;
import com.rimi.item.service.impl.LoginServiceImpl;
import com.rimi.item.util.CookieUtils;
import com.rimi.item.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 14:06
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(LoginConstant.LOGIN_USERNAME);
        String password = request.getParameter(LoginConstant.LOGIN_PASSWORD);
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)) {
            error(request, response);
        }else{
            login(request, response, username, password);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session
        HttpSession session = request.getSession();
        // 判断session中是否有用户
        if (session != null && session.getAttribute(LoginConstant.LOGIN_USERNAME)!=null){
            response.sendRedirect(request.getContextPath()+"/welcome.jsp");
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response, String username, String password) throws IOException, ServletException {
        ILoginService loginService=new LoginServiceImpl();
        boolean login = loginService.selectByUsernameAndPassword(username, password, request);
        if(login) {
            String remember = request.getParameter(LoginConstant.LOGIN_REMEMBER);
            if(remember!=null) {
                CookieUtils.cookie(LoginConstant.LOGIN_USERNAME,username,7*24*60*60,response);
                CookieUtils.cookie(LoginConstant.LOGIN_PASSWORD,password,7*24*60*60,response);
            }
            response.sendRedirect(request.getContextPath()+"/welcome.jsp");
        }else{
            error(request, response);
        }
    }

    private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(LoginConstant.LOGIN_ERROR, ErrorConstant.LOGIN_ERROR.getMsg());
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
