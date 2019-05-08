package com.software.view;

import java.util.Scanner;

import com.software.entity.User;
import com.software.service.impl.UserServiceImpl;

public class LoginView {

	public void login(int type) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String userName = scanner.next();
		
		System.out.println("请输入密码：");
		String passWord = scanner.next();
		
		User user = new UserServiceImpl().login(userName);
		if (user == null) {
			System.out.println("用户名不存在！");
			relogin(type);
		} else if (!user.getPassWord().equals(passWord)) {
			System.out.println("用户密码输入错误！");
			relogin(type);
		} else if (user.getType() != type) {
			System.out.println("用户角色错误，未获得角色权限");
			relogin(type);
		} else {
			System.out.println("登陆成功！欢迎您！" + userName);
		}

	}

	public void relogin(int type) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("========登陆失败！========");
		System.out.println("====是否重新登陆？(Y \\ N)====");
		String choose = scanner.next();
		if (choose.equalsIgnoreCase("y")) {
			new StartView().start();
			login(type);
		} else {
			new StartView().start();
		}
	}

}
