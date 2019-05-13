package com.software.service;

import java.util.List;

import com.software.entity.User;

/**
 * @author Neo
 * @version 创建时间：2019年5月6日 上午11:22:01 
 */
public interface IUserService {
	/**
	 * 验证登陆是否成功
	 * @param userName
	 * @param passWord
	 * @return 如果返回user不为空则为登录成功，反之不成功
	 */
	public User login(String userName);
	public List<User> userList();
	public int register(User user);

}
