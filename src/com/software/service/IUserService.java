package com.software.service;

import java.util.List;

import com.software.entity.User;

/**
 * @author Neo
 * @version ����ʱ�䣺2019��5��6�� ����11:22:01 
 */
public interface IUserService {
	/**
	 * ��֤��½�Ƿ�ɹ�
	 * @param userName
	 * @param passWord
	 * @return �������user��Ϊ����Ϊ��¼�ɹ�����֮���ɹ�
	 */
	public User login(String userName);
	public List<User> userList();
	public int register(User user);

}
