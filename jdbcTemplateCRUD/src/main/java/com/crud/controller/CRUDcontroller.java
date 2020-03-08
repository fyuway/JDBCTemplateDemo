package com.crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.dao.UserDao;
import com.crud.pojo.User;

@Controller
public class CRUDcontroller {

	/*
	 * Attributes===>
	 * 
	 */
	@Autowired
	private UserDao userDao;

	/*
	 * Controller Operation===>
	 * 
	 */
	@GetMapping("/users/{id}")
	@ResponseBody
	public User getUserById(@PathVariable("id") int id) {
		User user = userDao.getUserById(id);
		return user;
	}

//	@GetMapping("/users/{id}")
//	@ResponseBody
//	@SuppressWarnings("rawtypes")
//	public Map getUserMapById(@PathVariable("id") String id) {
//		Map map = userDao.getMapById(Integer.parseInt(id));
//		return map;
//	}

	@GetMapping("/users")
	@ResponseBody
	@SuppressWarnings("rawtypes")
	public List getAllUser() {
		List list = userDao.getAllUser();
		return list;
	}

	@PostMapping("/users")
	@ResponseBody
	public String saveUser(@RequestBody User user) {
		String msg = userDao.saveUser(user);
		return msg;
	}

	@PatchMapping("/users/{id}")
	@ResponseBody
	public String updateUserPassword(@PathVariable("id") int id, @RequestBody String newPassword) {
		String msg = userDao.updateUserPassword(id, newPassword);
		return msg;
	}

	@DeleteMapping("/users/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable("id") int id) {
		String msg = userDao.deleteUserById(id);
		return msg;
	}

}// End of Class
