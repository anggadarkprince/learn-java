package com.sketchproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by angga on 06/11/16.
 */
public class UserModel {

    public UserModel() {

    }

    public boolean insert(User user) {
        try {
            String sql = "INSERT INTO users(first_name, last_name, username) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<User> selectAll() {
        try {
            String query = "SELECT * FROM users";
            Statement statement = Connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("username")
                ));
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
            PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("username")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(User user) {
        try {
            String sql = "UPDATE users SET first_name = ?, last_name = ?, username = ? WHERE id = ?";
            PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setInt(4, user.getId());
            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                return true;
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
