package com.liverton.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.liverton.entity.User;
import com.liverton.entity.UserRole;

@Repository("userDAO")
public class UserDAOImpl /* extends HibernateDaoSupport */ implements UserDAO {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public User findByUserName(String username) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		User user = namedParameterJdbcTemplate.queryForObject("SELECT * FROM users WHERE username=:username", params,
				new UserMapper());
		UserRole userRole = namedParameterJdbcTemplate
				.queryForObject("SELECT * FROM user_roles WHERE username=:username", params, new UserRoleMapper());
		Set<UserRole> userRoles = new HashSet<UserRole>();
		userRoles.add(userRole);
		user.setUserRole(userRoles);
		return user;
	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			boolean isEnabled = false;
			if (rs.getInt("enabled") == 1) {
				isEnabled = true;
			}
			user.setEnabled(isEnabled);
			return user;
		}
	}

	private static final class UserRoleMapper implements RowMapper<UserRole> {

		public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserRole userRole = new UserRole();
			userRole.setUserRoleId(rs.getInt("user_role_id"));
			userRole.setRole(rs.getString("role"));
			User user = new User();
			user.setUsername(rs.getString("username"));
			userRole.setUser(user);

			return userRole;
		}
	}

}
