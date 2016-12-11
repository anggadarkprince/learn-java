package com.sketchproject.worldmanager.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationStartup
 */
@WebListener
public class ApplicationStartup implements ServletContextListener {

    public ApplicationStartup() {

    }

    public void contextInitialized(ServletContextEvent ctxt) {
        //add the application attribute
        ctxt.getServletContext().setAttribute("uid", "appUser");
        ctxt.getServletContext().setAttribute("pwd", "appUserPwd");
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

}
