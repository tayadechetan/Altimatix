package com.ac.altimatix.Altimatix.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
 

import org.springframework.jdbc.core.RowMapper;

import com.ac.altimatix.Altimatix.model.User;

public class UserMapper  implements RowMapper<User> {
 
    public static final String BASE_SQL //
            = "Select u.id, u.email, u.password From user u ";
 
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    	System.out.println("---------------------- inside mapRow ---------- " + rs.getString("email"));
        Long userId = rs.getLong("id");
        String userName = rs.getString("email");
        String encrytedPassword = rs.getString("password");
        User user = new User("","","","", userName, encrytedPassword);
        user.setId(userId);
        return user;
    }
 
}