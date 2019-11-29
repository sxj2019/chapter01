package com.smart4j.chapter01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 12:10
 **/
@WebServlet("/hello11")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        String dateStr = dateFormat.format(new Date());
        req.setAttribute("date",dateStr);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }
}
