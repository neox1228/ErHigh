package com.software.view;

import java.util.Scanner;

import com.software.entity.User;
import com.software.service.impl.UserServiceImpl;

public class LoginView {

	public void login(int type) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������û�����");
		String userName = scanner.next();
		
		System.out.println("���������룺");
		String passWord = scanner.next();
		
		User user = new UserServiceImpl().login(userName);
		if (user == null) {
			System.out.println("�û��������ڣ�");
			relogin(type);
		} else if (!user.getPassWord().equals(passWord)) {
			System.out.println("�û������������");
			relogin(type);
		} else if (user.getType() != type) {
			System.out.println("�û���ɫ����δ��ý�ɫȨ��");
			relogin(type);
		} else {
			System.out.println("��½�ɹ�����ӭ����" + userName);
		}

	}

	public void relogin(int type) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("========��½ʧ�ܣ�========");
		System.out.println("====�Ƿ����µ�½��(Y \\ N)====");
		String choose = scanner.next();
		if (choose.equalsIgnoreCase("y")) {
			new StartView().start();
			login(type);
		} else {
			new StartView().start();
		}
	}

}
