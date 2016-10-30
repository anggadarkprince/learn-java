package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by angga on 30/10/16.
 */
public class Connector {
    private String url = "jdbc:mysql://localhost/sandbox?useSSL=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "anggaari";
    private static Connection connection;

    public Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection opened");
                return connection;
            } catch (SQLException e) {
                System.err.println(e);
            }
            return null;
        }
    }

    public void close() {
        System.out.println("Closing connection");
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
