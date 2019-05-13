package com.software.view;

import java.util.Scanner;

public class StartView {
	public static void main(String[] args) {

		StartView startView = new StartView();
		startView.start();
	}

	public void start() {
		System.out.println("==================");
		System.out.println("      神船租车                ");
		System.out.println("==================");
		System.out.println("1.用户，2.管理员，3.退出");
		Scanner scanner = new Scanner(System.in);
		String choose = scanner.next();
		LoginView loginView = new LoginView();
		switch (choose) {
		case "1":
			// 用户登录
			loginView.login(0);
			break;
		case "2":
			// 管理员登录
			loginView.login(1);
			break;
		case "3":
			// 退出
			System.out.println("==================");
			System.out.println("  欢迎再次访问神船租车");
			System.out.println("==================");
			
			System.exit(0);
			break;
		default:
			System.out.println("输入有误！！");
			start();
			break;
		}
	}

}
