package com.software.dao;
/**
 * 接口说明
 * @author Neo
 * @version 创建时间：2019年5月6日 上午9:57:38 
 */

import java.sql.SQLException;
import java.util.List;
import com.software.entity.User;

public interface IUserDao {

	/**
	 * 通过用户名和密码查找用户信息
	 * 
	 * @param userName
	 * @param passWord
	 * @return List<User>
	 */
	public List<User> getUser (String userName) throws SQLException;
    public int addUser (User user) throws SQLException;
}
