package com.smart4j.chapter04.Controller;

import com.smart4j.chapter04.Action.Action;
import com.smart4j.chapter04.Action.ActionFactory;
import com.smart4j.chapter04.pojo.Param;
import com.smart4j.chapter04.pojo.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-30 22:16
 **/
@WebServlet(urlPatterns = "/cs04/*")
public class DispatcherServlet extends HttpServlet {

    protected ActionFactory factory = new ActionFactory();


    //获取Action的名称
    protected String getReqUrl(HttpServletRequest req) {
        String pathInfo = req.getPathInfo();
        return pathInfo.substring(1);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqMethod = req.getMethod().toLowerCase();
        String reqUrl = getReqUrl(req);
        Action action = factory.create(reqMethod, reqUrl);
        Param param = new Param(req);
        Object retVal = action.execute(param);
        if (retVal instanceof View){
            View view = (View) retVal;
            String path = view.getPath();
            if (path.startsWith("/")){
                String servletPath = "/cs04";
                String contextPath = req.getContextPath();
                resp.sendRedirect(contextPath+servletPath+path);
            }else {
                Map<String, Object> model = view.getModel();
                model.forEach((s, o) -> {
                    req.setAttribute(s,o);
                });
                String jspPackage = "/WEB-INF/jsp04/";
                String suffix = ".jsp";
                req.getRequestDispatcher(jspPackage+path+suffix).forward(req,resp);
            }
        }
    }

}
