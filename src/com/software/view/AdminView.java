package com.software.view;

import java.util.Scanner;

public class AdminView {
	private static int type = 1;
	public void adminLoginView(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("==================");
		System.out.println("       ����Ա                  ");
		System.out.println("==================");
		System.out.println("1.��½��2.�˳�");
		String choose = scanner.next();
		switch (choose) {
		case "1":
			// ��½
			LoginView loginView = new LoginView();
			loginView.login(type);
			break;
		case "2":
			// �˳�
			System.out.println("��ӭ�ٴη������⳵");
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
}
