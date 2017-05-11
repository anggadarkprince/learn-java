/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datauser.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Angga
 */
public class UserModel {
    private Connection connection;
    
    public UserModel(){
        connection = new Connector().getConnection();
    }
    
    public boolean insert(User user){
        try{
            String sql = "INSERT INTO users(first_name, last_name, username) VALUES(?, ?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, user.getFirst_name());
            prepareStatement.setString(2, user.getLast_name());
            prepareStatement.setString(3, user.getUsername());
            int affected = prepareStatement.executeUpdate();
            if(affected > 0){
                return true;
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public ArrayList<User> selectAll(){
        try{
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<User> users = new ArrayList();
            while(resultSet.next()){
                users.add(new User(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("username")
                ));
            }
            return users;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public Object[][] selectAllObject(){
        try{
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.last();
            System.out.println("row " + resultSet.getRow());
            Object[][] users = new Object[resultSet.getRow()][4];
            resultSet.beforeFirst();
            int row = 0;
            while(resultSet.next()){
                System.out.println(resultSet.getString("first_name"));
                users[row][0] = resultSet.getString("id");
                users[row][1] = resultSet.getString("first_name");
                users[row][2] = resultSet.getString("last_name");
                users[row][3] = resultSet.getString("username");
                row++;
            }
            return users;
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public User selectById(int id){
        try{
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            if(resultSet.next()){
                return new User(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("username")
                );
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public boolean update(User user){
        try{
            String sql = "UPDATE users SET first_name = ?, last_name = ?, username = ? WHERE id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, user.getFirst_name());
            prepareStatement.setString(2, user.getLast_name());
            prepareStatement.setString(3, user.getUsername());
            prepareStatement.setInt(4, user.getId());
            int affected = prepareStatement.executeUpdate();
            if(affected > 0){
                return true;
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean delete(int id){
        try{
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            int affected = prepareStatement.executeUpdate();
            if(affected > 0){
                return true;
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
