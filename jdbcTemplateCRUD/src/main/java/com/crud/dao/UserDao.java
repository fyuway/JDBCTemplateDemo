package com.crud.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.pojo.User;

@Repository
public class UserDao {

	/*
	 * Attributes===>
	 * 
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * DAO Operation===>
	 * 
	 */
	public User getUserById(int id) {
		String sql = "SELECT * FROM USER WHERE ID = ?";
		User user = jdbcTemplate.queryForObject(sql, new User(), new Object[] { id });
		return user;
	}

	@SuppressWarnings("rawtypes")
	public Map getMapById(int id) {
		String sql = "SELECT * FROM USER WHERE ID = ?";
		Map map = jdbcTemplate.queryForMap(sql, id);
		return map;
	}

	@SuppressWarnings("rawtypes")
	public List getAllUser() {
		String sql = "SELECT * FROM USER";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	public String saveUser(User user) {
		int rows = jdbcTemplate.update("INSERT INTO USER (USER_NAME,PASS_WORD) VALUES (?,?)", user.getUser_name(),
				user.getUser_password());
		if (rows > 0) {
			return "Insert success....";
		}
		return "Insert fail....";
	}

	public String updateUserPassword(int id, String newPassword) {
		int rows = jdbcTemplate.update("UPDATE USER SET PASS_WORD = ? WHERE ID = ?", newPassword, id);
		if (rows > 0) {
			return "Update success....";
		}
		return "Update fail....";
	}

	public String deleteUserById(int id) {
		int rows = jdbcTemplate.update("DELETE FROM USER WHERE ID = ?", id);
		if (rows > 0) {
			return "Delete success....";
		}
		return "Delete fail....";
	}

}// End of Class
