package com.sketchproject.worldmanager.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request
 */
@WebServlet("/RequestScope.do")
public class RequestScope extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RequestScope() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("uid", "reqUser");
        request.setAttribute("pwd", "reqUserPwd");
        RequestDispatcher rd = request.getRequestDispatcher("RequestScope.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
