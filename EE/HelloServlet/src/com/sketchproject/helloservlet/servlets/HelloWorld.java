package com.sketchproject.helloservlet.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by angga on 04/12/16.
 */
@WebServlet(name = "HelloWorld", urlPatterns = "/helloworld")
public class HelloWorld extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        double sqrtValue = Math.sqrt(4.0);
        out.println("<html><body>Hello, square of 4 is "+ sqrtValue +"</body></html>");
    }
}
