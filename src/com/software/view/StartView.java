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
		switch (choose) {
		case "1":
			// �û���¼
			UserView userView = new UserView();
			userView.userLoginView();
			break;
		case "2":
			// ����Ա��¼
			AdminView adminView = new AdminView();
			adminView.adminLoginView();
			break;
		case "3":
			// �˳�
			System.out.println("��ӭ�ٴη������⳵");
			System.exit(0);
			break;
		default:System.out.println("�������󣡣�");
			break;
		}
	}

}
