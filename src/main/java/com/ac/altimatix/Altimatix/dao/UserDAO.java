package com.ac.altimatix.Altimatix.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ac.altimatix.Altimatix.mapper.UserMapper;
import com.ac.altimatix.Altimatix.model.User;

@Repository
@Transactional
public class UserDAO extends JdbcDaoSupport {

	@Autowired
	public UserDAO(DataSource dataSource) {
		System.out.println("---------------- inside userdao() constructor ------------- " + dataSource);
        this.setDataSource(dataSource);
    }
	
	public User findUserAccount(String userName) {
    // Select .. from App_User u Where u.User_Name = ?
		System.out.println("-------------- inside findUserAccount -------------- ");
    String sql = UserMapper.BASE_SQL + " where u.email = ? ";

    Object[] params = new Object[] { userName };
    UserMapper mapper = new UserMapper();
    try {
        User userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
        return userInfo;
    } catch (EmptyResultDataAccessException e) {
        return null;
    }
}

}