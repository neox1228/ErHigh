package com.software.view;

import java.util.Scanner;

public class UserView {
	private static int type = 0;
	public void userLoginView() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("==================");
		System.out.println("        用户                   ");
		System.out.println("==================");
		System.out.println("1.登陆，2.注册，3.退出，4.查询");
		String choose = scanner.next();
		switch (choose) {
		case "1":
			// 登陆
			LoginView loginView = new LoginView();
			loginView.login(type);
			break;
		case "2":
			// 注册
			new RegisterView().register();
			break;
		case "4":
			// 注册
			new QueryView().queryResult(type);
			break;
		case "3":
			// 退出
			System.out.println("欢迎再次访问神船租车");
			System.exit(0);

			break;

		default:
			break;
		}
	}

}
