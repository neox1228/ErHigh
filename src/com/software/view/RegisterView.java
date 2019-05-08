package com.software.view;

import java.util.Scanner;

import com.software.entity.User;
import com.software.service.impl.UserServiceImpl;

public class RegisterView {
	public void register() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("========用户注册========");
		System.out.println("----------------");
		System.out.println("用户名：");
		String userName = scanner.next();
		System.out.println("----------------");
		System.out.println("登陆密码：");
		String passWord = scanner.next();
		System.out.println("----------------");
		System.out.println("选择性别（1：女，0：男）：");
		int sex = scanner.nextInt();
		System.out.println("----------------");
		System.out.println("身份证号：");
		String idNumber = scanner.next();
		System.out.println("----------------");
		System.out.println("电话号码：");
		String tel = " ";
		while(true) {
			tel = scanner.next();
			if (tel.length() != 11) {
				System.out.println("格式错误！请重新输入：");
			}else {
				break;
			}
		}
		System.out.println("----------------");
		System.out.println("家庭住址：");
		String addr = scanner.next();
		System.out.println("----------------");
		User user = new User(0,userName, passWord, sex, idNumber, tel, addr,0);
		UserServiceImpl usi = new UserServiceImpl();
		int row = usi.register(user);
		StartView startView = new StartView();
		if (row > 0) {
			System.out.println("用户名不存在，注册成功！");
			startView.start();
		}else {
			System.out.println("用户名已存在，注册失败！");
			System.out.println("是否重新注册？（Y or N）");
			String choose = scanner.next();
			if (choose.equals("y") || choose.equals("Y")) {
				register();
			}else {
				
			}
		}
	}

}
