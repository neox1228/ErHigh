package com.software.view;

import java.util.Scanner;


public class AdminView {
	private static int type = 1;
	public void functionView(long userID) {
		UpdateView updateView = new UpdateView();
		QueryView queryView = new QueryView();
		Scanner scanner = new Scanner(System.in);
		System.out.println("==================����Ա��������====================");
		System.out.println("0.������һ��");
		System.out.println("1.�鿴������¼");
		System.out.println("2.�������");
		System.out.println("3.�޸�������Ϣ");
		System.out.println("4.�鿴�⳵��Ϣ");
		int key = scanner.nextInt();
		switch (key) {
		case 0:
			new LoginView().login(type);
			break;
		case 1:
			queryView.queryCarView(type,userID);
			break;
		case 2:
			updateView.addCar(userID);
			break;
		case 3:
			updateView.updateCarMess(userID);
			break;
		case 4:
			queryView.queryRecordView(type, userID);
			break;
		default:
			System.out.println("���޴˹��ܣ���");
			break;
		}
		functionView(userID);
	}
}
