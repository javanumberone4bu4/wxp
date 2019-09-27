package com.rimi.item.servlet;

import com.alibaba.fastjson.JSONObject;
import com.rimi.item.common.BaseServlet;
import com.rimi.item.common.LayuiData;
import com.rimi.item.common.Page;
import com.rimi.item.entity.User;
import com.rimi.item.service.ILoginService;
import com.rimi.item.service.impl.LoginServiceImpl;
import com.rimi.item.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 21:28
 */
@WebServlet("/admin")
public class AdminServlet extends BaseServlet {
    private ILoginService loginService=new LoginServiceImpl();
    public String doList(HttpServletRequest request,HttpServletResponse response) {
        return "admin/admin-list";
    }

    public void doData(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String currentPage = request.getParameter("page");
        String limit = request.getParameter("limit");
        Page page = Page.of(Integer.valueOf(currentPage));
        page.setPageSize(Integer.valueOf(limit));
        // 调用分页方法获取数据
        Map<String, String[]> params = request.getParameterMap();
        Page<User> booksPage = loginService.findPagedBooks(params,page);
        LayuiData data = new LayuiData();
        data.setCode(0);
        data.setCount(booksPage.getTotalCount());
        data.setMsg("");
        data.setData(booksPage.getPageData());
        // 把对象转出JSON
        String jsonString = JSONObject.toJSONString(data);
        response.setContentType("application/json;charset=utf8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonString);
        writer.close();
    }

    public String doAdd(HttpServletRequest request,HttpServletResponse response){
        return "admin/admin-add";
    }
    public String doSave(HttpServletRequest request,HttpServletResponse response){
        // 获取参数列表
        Map<String, String[]> params = request.getParameterMap();
        // 调用保存方法
        loginService.save(params);
        return "redirect:"+request.getContextPath()+"/admin?method=list";

    }
    public String doEdit(HttpServletRequest request,HttpServletResponse response){
        // 1.获取提交的参数
        String id = request.getParameter("id");
        // 2.根据ID获取修改的图书信息
       User user = loginService.findById(id);
        // 3. 把用户信息显示到页面中
        request.setAttribute("user", user);
        return "admin/admin-edit";
    }
    public void doUpdate(HttpServletRequest request,HttpServletResponse response){
        // 获取所有的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 调用方法
        boolean update = loginService.update(parameterMap);
        JSONObject object = new JSONObject();
        object.put("code",0);
        try {
            response.getWriter().print(object.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回列表
        //return "redirect:"+request.getContextPath()+"/admin?method=list";
    }
    public void doDel(HttpServletRequest request,HttpServletResponse response){
         //获取参数
        String[] ids = request.getParameterValues("id[]");
        // 调用service,处理请求
        loginService.deleteByIds(ids);
    }

}
