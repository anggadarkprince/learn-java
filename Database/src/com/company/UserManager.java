package com.company;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by angga on 30/10/16.
 */
public class UserManager {
    private Connection connection;

    public UserManager() {
        Connector connector = new Connector();
        connection = connector.getConnection();
    }

    public ArrayList<User> selectAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User selectById(int id) {
        try {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User insert(User user) {
        try {
            String sql = "INSERT into users (first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            int affected = preparedStatement.executeUpdate();

            System.out.println("Record inserted " + affected + " rows affected");

            ResultSet keys = preparedStatement.getGeneratedKeys();
            keys.next();
            user.setId(keys.getInt(1));
            return user;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(User user) {
        try {
            String sql = "UPDATE users set first_name = ?, last_name = ?, username = ?, password = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId());
            int affected = preparedStatement.executeUpdate();

            System.out.println("Record updated " + affected + " rows affected");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int affected = preparedStatement.executeUpdate();

            System.out.println("Record deleted " + affected + " rows affected");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
