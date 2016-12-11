package com.sketchproject.jsps.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimulateException
 */
@WebServlet("/simulateException.do")
public class SimulateException extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SimulateException() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i = 10;
        int j = 0;
        int k = i / j;
        PrintWriter out = response.getWriter();
        out.println("The result is " + k);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
