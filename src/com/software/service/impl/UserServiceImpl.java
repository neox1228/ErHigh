package com.software.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.software.dao.impl.UserDaoImpl;
import com.software.entity.User;
import com.software.service.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public User login(String userName) {
		
		try {
			//调用dao层方法得到返回值
			List<User> userList = new UserDaoImpl().getUser(userName);
			
			//根据返回值判断是否登陆为空
			if (userList.size()!=0) {
				User user = userList.get(0);
				return user;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int register(User user) {
		int row = -1;
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			User selectUser = login(user.getUserName());
			if ( selectUser == null) {
				row = userDaoImpl.addUser(user);	
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<User> userList() {
		List<User> userList = null;
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			userList = userDaoImpl.getUser(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	

}
