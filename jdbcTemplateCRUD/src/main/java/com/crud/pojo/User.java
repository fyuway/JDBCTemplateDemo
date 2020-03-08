package com.crud.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class User implements RowMapper<User> {
	
	private int id;
	private String user_name;
	private String user_password;
	
	
	
	public User() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getUser_password() {
		return user_password;
	}
	
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	

	//TO use JDBCTemplate, need to implement RowMapper<T> and override mapRow() method.
	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUser_name(resultSet.getString("user_name"));
        user.setUser_password(resultSet.getString("pass_word"));
        return user;
	}

}//End of Class
