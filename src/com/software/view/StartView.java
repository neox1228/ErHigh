package com.software.view;

import java.util.Scanner;

public class StartView {
	public static void main(String[] args) {

		StartView startView = new StartView();
		startView.start();
	}

	public void start() {
		System.out.println("==================");
		System.out.println("      ���⳵                ");
		System.out.println("==================");
		System.out.println("1.�û���2.����Ա��3.�˳�");
		Scanner scanner = new Scanner(System.in);
		String choose = scanner.next();
		LoginView loginView = new LoginView();
		switch (choose) {
		case "1":
			// �û���¼
			loginView.login(0);
			break;
		case "2":
			// ����Ա��¼
			loginView.login(1);
			break;
		case "3":
			// �˳�
			System.out.println("==================");
			System.out.println("  ��ӭ�ٴη������⳵");
			System.out.println("==================");
			
			System.exit(0);
			break;
		default:
			System.out.println("�������󣡣�");
			start();
			break;
		}
	}

}
