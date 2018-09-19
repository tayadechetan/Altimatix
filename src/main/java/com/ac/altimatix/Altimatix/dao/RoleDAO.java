package com.ac.altimatix.Altimatix.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class RoleDAO  extends JdbcDaoSupport {

	@Autowired
    public RoleDAO(DataSource dataSource) {
		System.out.println("---------- inside roledao constructor -----------");
        this.setDataSource(dataSource);
    }
 
    public List<String> getRoleNames(Long userId) {
        String sql = "Select r.name " //
                + " from users_roles ur, role r " //
                + " where ur.role_id = r.id and ur.user_id = ? ";
 
        Object[] params = new Object[] { userId };
 
        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);
 
        return roles;
    }
}