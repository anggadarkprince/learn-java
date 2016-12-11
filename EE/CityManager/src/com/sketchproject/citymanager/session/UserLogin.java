package com.sketchproject.citymanager.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/userLogin.do")
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLogin() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //here we would put some logic to validate the user.
        //simulate...
        String uid = "authorizedUser";
        int authLevel = 1;

        String username = request.getParameter("userID");
        String password = request.getParameter("pwd");

        if(!username.equals("user") || !password.equals("secret")){
            uid = null;
            authLevel = -1;
        }

        //assuming the user is valid, let's set some information into session
        //in this way, ALL jsp pages and servlets going forward can access the value

        //to start a session, get the session from the request into a variable
        //add import javax.servlet.http.HttpSession;
        HttpSession session = request.getSession();
        //just like other examples, use the session variable to get and set attributes
        session.setAttribute("userName", uid);
        session.setAttribute("userAuthLevel", authLevel);

        //redirect
        if (authLevel < 1 || uid == null || uid == "") {
            //send back to calling page or forward to
            //unauthorized notification
            response.sendRedirect("Login.html");

            // anticipate when user turn off their cookies, redirect with encode query string
            //response.sendRedirect(response.encodeRedirectURL("Login.html"));
        } else {
            //forward to requested page or menu page/home page with authorization
            response.sendRedirect("/CityManager_war_exploded/destinationPage.do");

            //redirect with add url string query for request
            //response.sendRedirect(response.encodeRedirectURL("/CityManager_war_exploded/destinationPage.do"));
        }
    }

}
