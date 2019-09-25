package com.rimi.item.servlet;

import com.alibaba.fastjson.JSONObject;
import com.rimi.item.common.BaseServlet;
import com.rimi.item.common.LayuiData;
import com.rimi.item.common.Page;
import com.rimi.item.entity.Order;
import com.rimi.item.entity.Rule;
import com.rimi.item.service.IOrderService;
import com.rimi.item.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ${Description}
 *
 * @author Wang Xiaoping
 * @date 2019/9/25 7:46
 */
@WebServlet("/order")
public class OrderServlet extends BaseServlet {
  private IOrderService orderService=new OrderServiceImpl();
    public String doAdd(HttpServletRequest request,HttpServletResponse response){
        return "order/order-add";
    }
    public String doList(HttpServletRequest request,HttpServletResponse response){
        return "order/order-list";
    }
    public void doData(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String currentPage = request.getParameter("page");
        String limit = request.getParameter("limit");
        Page page = Page.of(Integer.valueOf(currentPage));
        page.setPageSize(Integer.valueOf(limit));
        // 调用分页方法获取数据
        Page<Order> booksPage = orderService.findPagedBooks(page);
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
}
