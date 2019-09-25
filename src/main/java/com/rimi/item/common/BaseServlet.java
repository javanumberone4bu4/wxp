package com.rimi.item.common;

import com.rimi.item.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 所有的servlet参照类
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 12:52
 */
public abstract class BaseServlet extends HttpServlet {
    private static final String METHOD="method";
    private static final String PREFIX="do";
    private static final String PATH_PREFIX="redirect:";

    private static final String VIEW_PREFIX = "/WEB-INF/";
    private static final String VIEW_SUFFIX = ".jsp";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter(METHOD);
        if (StringUtils.isNotEmpty(method)) {
            String doMethod = StringUtils.appendString(PREFIX, method);
            Class<? extends BaseServlet> aClass = this.getClass();
            try {
                Method method1 = aClass.getMethod(doMethod, HttpServletRequest.class, HttpServletResponse.class);
                Object value = method1.invoke(this, req, resp);
                if (value instanceof String ){
                   String result=(String)value;
                    if (StringUtils.isNotEmpty(result)) {
                        if(result.startsWith(PATH_PREFIX)) {
                            String path = result.substring(PATH_PREFIX.length());
                            resp.sendRedirect(path);
                        }else {
                            req.getRequestDispatcher(VIEW_PREFIX + result + VIEW_SUFFIX).forward(req,resp);
                        }

                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }
}
