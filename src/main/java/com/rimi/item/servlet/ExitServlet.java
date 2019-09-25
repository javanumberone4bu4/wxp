package com.rimi.item.servlet;

import com.rimi.item.common.LoginConstant;

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
 * @date 2019/9/23 21:12
 */
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(LoginConstant.LOGIN_USERNAME);
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
