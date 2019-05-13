package com.software.view;

import java.util.Scanner;

public class UserView {
	private static int type = 0;
	public void functionView(long userID) {
		Scanner scanner = new Scanner(System.in);
		RentView rentView = new RentView();
		QueryView queryView = new QueryView();
		System.out.println("==================用户操作界面====================");
		System.out.println("0.返回上一级");
		System.out.println("1.租车订单");
		System.out.println("2.查看汽车记录");
		System.out.println("3.查看我的租车记录");
		System.out.println("4.还车");
		int key = scanner.nextInt();
		switch (key) {
		case 0:
			new LoginView().login(type);
			break;
		case 1:
			//租车
			rentView.rentCarView(userID); 
			break;
		case 2:
			queryView.queryCarView(type, userID);
			break;
		case 3:
			queryView.queryRecordView(type, userID);
			break;
		default:
			System.out.println("暂无此功能！！");
			break;
		}
		functionView(userID);
	}
}
