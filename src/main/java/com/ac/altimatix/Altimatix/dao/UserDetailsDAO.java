package com.ac.altimatix.Altimatix.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ac.altimatix.Altimatix.mapper.UserDetailMapper;
import com.ac.altimatix.Altimatix.mapper.UserMapper;
import com.ac.altimatix.Altimatix.model.User;

@Repository
@Transactional
public class UserDetailsDAO extends JdbcDaoSupport {

	@Autowired
	public UserDetailsDAO(DataSource dataSource) {
		System.out.println("---------------- inside UserDetailsDAO() constructor ------------- " + dataSource);
        this.setDataSource(dataSource);
    }
	
	public User findUserAccountDetail(String userName) {
		String sql = UserDetailMapper.BASE_SQL + " where u.email = ? ";
		Object[] params = new Object[] { userName };
		UserDetailMapper mapper = new UserDetailMapper();
	    try {
	        User userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
	        System.out.println("-----1-------- "+userInfo.toString());
	        return userInfo;
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

	

}


