package com.ac.altimatix.Altimatix.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ac.altimatix.Altimatix.model.User;

public class UserDetailMapper implements RowMapper<User> {
 
    public static final String BASE_SQL //
            = "Select u.id, u.email, u.first_name, u.last_name, u.current_year, u.mobile_number From user u ";
 
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    	System.out.println("---------------------- inside mapRow user detail---------- " + rs.getString("email"));
        Long userId = rs.getLong("id");
        String email = rs.getString("email");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String currentYear = rs.getString("current_year");
        String mobileNumber = rs.getString("mobile_number");
        
        User user = new User(firstName,lastName,currentYear,mobileNumber, email, "");
        user.setId(userId);
        return user;
    }

}
