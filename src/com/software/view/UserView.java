package com.software.view;

import java.util.Scanner;

public class UserView {
	private static int type = 0;
	public void functionView(long userID) {
		Scanner scanner = new Scanner(System.in);
		RentView rentView = new RentView();
		QueryView queryView = new QueryView();
		System.out.println("==================�û���������====================");
		System.out.println("0.������һ��");
		System.out.println("1.�⳵����");
		System.out.println("2.�鿴������¼");
		System.out.println("3.�鿴�ҵ��⳵��¼");
		System.out.println("4.����");
		int key = scanner.nextInt();
		switch (key) {
		case 0:
			new LoginView().login(type);
			break;
		case 1:
			//�⳵
			rentView.rentCarView(userID); 
			break;
		case 2:
			queryView.queryCarView(type, userID);
			break;
		case 3:
			queryView.queryRecordView(type, userID);
			break;
		default:
			System.out.println("���޴˹��ܣ���");
			break;
		}
		functionView(userID);
	}
}
