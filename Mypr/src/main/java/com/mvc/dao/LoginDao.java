package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;

public class LoginDao {
    
    public String authenticateUser(LoginBean loginBean) {
        String userId = loginBean.getUserId();
        String password = loginBean.getPassword();
        
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM users WHERE userName = ? AND password = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                return "SUCCESS"; // If credentials match, return SUCCESS
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return "Invalid userid or password !"; // If credentials are invalid, return error message
    }
}