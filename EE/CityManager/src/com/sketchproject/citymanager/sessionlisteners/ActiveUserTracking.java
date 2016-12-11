package com.sketchproject.citymanager.sessionlisteners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ActiveUserTracking
 */
@WebListener
public class ActiveUserTracking implements HttpSessionListener {
    private static int activeUsers;

    /**
     * Default constructor.
     */
    public ActiveUserTracking() {

    }

    public void sessionCreated(HttpSessionEvent hse) {
        System.out.println("A new Session was created");
        activeUsers++;
    }

    public void sessionDestroyed(HttpSessionEvent hse) {
        System.out.println("An existing Session was destroyed");
        activeUsers--;
    }

    public static int getActiveUserCount() {
        return activeUsers;
    }
}
