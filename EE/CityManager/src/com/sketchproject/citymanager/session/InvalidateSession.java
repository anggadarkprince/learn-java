package com.sketchproject.citymanager.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InvalidateSession
 */
@WebServlet("/invalidateSession.do")
public class InvalidateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InvalidateSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		s.invalidate();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Session invalidated, please login again");
	}
}
