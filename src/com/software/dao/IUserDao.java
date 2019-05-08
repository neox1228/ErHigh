package com.software.dao;
/**
 * �ӿ�˵��
 * @author Neo
 * @version ����ʱ�䣺2019��5��6�� ����9:57:38 
 */

import java.sql.SQLException;
import java.util.List;
import com.software.entity.User;

public interface IUserDao {

	/**
	 * ͨ���û�������������û���Ϣ
	 * 
	 * @param userName
	 * @param passWord
	 * @return List<User>
	 */
	public List<User> getUser (String userName) throws SQLException;
    public int addUser (User user) throws SQLException;
}
