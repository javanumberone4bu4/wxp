package com.rimi.item.servlet;

import com.alibaba.fastjson.JSONObject;
import com.rimi.item.common.BaseServlet;
import com.rimi.item.common.LayuiData;
import com.rimi.item.common.Page;
import com.rimi.item.entity.Role;
import com.rimi.item.entity.User;
import com.rimi.item.service.IRoleService;
import com.rimi.item.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/9/24 21:38
 */
@WebServlet("/role")
public class RoleServlet extends BaseServlet {
    private IRoleService roleService=new RoleServiceImpl();
    public String doList(HttpServletRequest request,HttpServletResponse response) {
        // 获取分页的参数(当前第几页)
        //String currentPage = request.getParameter("page");
        //if (StringUtils.isEmpty(currentPage)){
        //    currentPage = "1";
        //}
        // 设置每页显示的条数
        // 创建一个分页对象
        //Page page = new Page();
        //page.setCurrentPage(Integer.valueOf(currentPage));
        //Page page = Page.of(Integer.valueOf(currentPage));
        //String limit = request.getParameter("limit");
        //page.setPageSize(Integer.valueOf(limit));
        // 调用分页方法获取数据
        //Page<User> booksPage = loginService.findPagedBooks(page);
        // 把分页的信息发送到页面
        //request.setAttribute("page",booksPage);
        //// 1.获取所有的图书
        //List<Books> list = booksService.getAll();
        //// 2.把图书列表存入到request域中,方便在页面通过jstl和el获取
        //request.setAttribute("list", list);
        return "admin/admin-role";
    }

    public void doData(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String currentPage = request.getParameter("page");
        String limit = request.getParameter("limit");
        Page page = Page.of(Integer.valueOf(currentPage));
        page.setPageSize(Integer.valueOf(limit));
        // 调用分页方法获取数据
        Page<Role> booksPage = roleService.findPagedBooks(page);
        LayuiData data = new LayuiData();
        data.setCode(0);
        data.setCount(booksPage.getPageCount());
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
        return "role/role-add";
    }
    public String doSave(HttpServletRequest request,HttpServletResponse response){
        // 获取参数列表
        Map<String, String[]> params = request.getParameterMap();
        // 调用保存方法
        roleService.save(params);
        return "redirect:"+request.getContextPath()+"/role?method=list";

    }
    public String doEdit(HttpServletRequest request,HttpServletResponse response){
        // 1.获取提交的参数
        String id = request.getParameter("id");
        // 2.根据ID获取修改的图书信息
        Role role = roleService.findById(id);
        // 3. 把用户信息显示到页面中
        request.setAttribute("role", role);
        return "role/role-edit";
    }
    public void doUpdate(HttpServletRequest request,HttpServletResponse response){
        // 获取所有的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 调用方法
        boolean update = roleService.update(parameterMap);
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
        roleService.deleteByIds(ids);
    }
}
