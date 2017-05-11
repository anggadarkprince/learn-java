/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datauser.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Angga
 */
public class Connector {
    private String url = "jdbc:mysql://localhost/sandbox?useSSL=false&ServerTimezone=UTC";
    private String user = "root";
    private String password = "";
    
    public Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
