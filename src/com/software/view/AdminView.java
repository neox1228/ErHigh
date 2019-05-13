package com.software.view;

import java.util.Scanner;


public class AdminView {
	private static int type = 1;
	public void functionView(long userID) {
		UpdateView updateView = new UpdateView();
		QueryView queryView = new QueryView();
		Scanner scanner = new Scanner(System.in);
		System.out.println("==================管理员操作界面====================");
		System.out.println("0.返回上一级");
		System.out.println("1.查看汽车记录");
		System.out.println("2.添加汽车");
		System.out.println("3.修改汽车信息");
		System.out.println("4.查看租车信息");
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
			System.out.println("暂无此功能！！");
			break;
		}
		functionView(userID);
	}
}
