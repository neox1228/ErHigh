package com.software.view;

import java.util.Scanner;

public class UserView {
	private static int type = 0;
	public void userLoginView() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("==================");
		System.out.println("        �û�                   ");
		System.out.println("==================");
		System.out.println("1.��½��2.ע�ᣬ3.�˳���4.��ѯ");
		String choose = scanner.next();
		switch (choose) {
		case "1":
			// ��½
			LoginView loginView = new LoginView();
			loginView.login(type);
			break;
		case "2":
			// ע��
			new RegisterView().register();
			break;
		case "4":
			// ע��
			new QueryView().queryResult(type);
			break;
		case "3":
			// �˳�
			System.out.println("��ӭ�ٴη������⳵");
			System.exit(0);

			break;

		default:
			break;
		}
	}

}
