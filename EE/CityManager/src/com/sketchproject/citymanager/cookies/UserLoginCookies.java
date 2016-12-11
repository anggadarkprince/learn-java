package com.sketchproject.citymanager.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLoginCookies
 */
@WebServlet("/userLoginCookies.do")
public class UserLoginCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLoginCookies() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //pull the values from these post variables
        String uid = request.getParameter("userID");
        String pwd = request.getParameter("pwd");
        boolean remember = false;
        if (request.getParameter("remember") != null) {
            String rememberMe = request.getParameter("remember");
            if (rememberMe.equalsIgnoreCase("on")) {
                remember = true;
            }
        }

        //here we would put some logic to validate the user.
        //simulate...
        int authLevel = 1;

        //to start a session, get the session from the request into a variable
        //add import javax.servlet.http.HttpSession;
        HttpSession session = request.getSession();
        //just like other examples, use the session variable to get and set attributes
        session.setAttribute("userName", uid);
        session.setAttribute("userAuthLevel", authLevel);

        if (remember) {
            //we also want to store the information in a cookie
            //for reuse later:
            int cookieLife = 3600 * 24 * 7; //7 days
            Cookie uidCook = new Cookie("credentials_uid", uid);
            uidCook.setMaxAge(cookieLife);  //7 days
            response.addCookie(uidCook);
            Cookie pwdCook = new Cookie("credentials_pwd", pwd);
            uidCook.setMaxAge(cookieLife);  //7 days
            response.addCookie(pwdCook);
        }

        //redirect
        if (authLevel < 1 || uid == null || uid == "") {
            //send back to calling page or forward to
            //unauthorized notification
            response.sendRedirect(response.encodeRedirectURL("index_cookies.html"));

        } else {
            //forward to requested page or menu page/home page with authorization
            response.sendRedirect(response.encodeRedirectURL("/CityManager_war_exploded/destinationPage.do"));
        }
    }

}
