package com.software.view;

import java.util.Scanner;

public class AdminView {
	private static int type = 1;
	public void adminLoginView(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("==================");
		System.out.println("       管理员                  ");
		System.out.println("==================");
		System.out.println("1.登陆，2.退出");
		String choose = scanner.next();
		switch (choose) {
		case "1":
			// 登陆
			LoginView loginView = new LoginView();
			loginView.login(type);
			break;
		case "2":
			// 退出
			System.out.println("欢迎再次访问神船租车");
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
}
