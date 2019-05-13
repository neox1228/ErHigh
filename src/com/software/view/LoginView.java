package com.software.view;

import java.util.List;
import java.util.Scanner;

import com.software.entity.Car;
import com.software.entity.User;
import com.software.service.impl.CarServiceImpl;
import com.software.service.impl.UserServiceImpl;

public class LoginView {
	public long login(int type) {
		long userID = 0;
		Scanner scanner = new Scanner(System.in);
		if (type == 0) {
			System.out.println("===========�û�============");
			System.out.println("1.��½��2.ע�ᣬ3.������һ��");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				userID = loginView(type);
				QueryView queryView = new QueryView();
				CarServiceImpl carServiceImpl = new CarServiceImpl();
				List<Car> inquireCar = carServiceImpl.inquireCar(1, type, null);
				queryView.querycar(type, inquireCar);
				new UserView().functionView(userID);
				break;
			case 2:
				new RegisterView().register();
				login(type);
				break;
			case 3:
				new StartView().start();
				break;
			default:
				System.out.println("�������󣡣���");
				login(type);
				break;
			}
			
		}else if (type == 1) {
			System.out.println("============����Ա============");
			System.out.println("1.��½��2.������һ��");
			int key = scanner.nextInt();
			switch (key) {
			case 1:
				userID = loginView(type);
				QueryView queryView = new QueryView();
				CarServiceImpl carServiceImpl = new CarServiceImpl();
				List<Car> inquireCar = carServiceImpl.inquireCar(1, type, null);
				queryView.querycar(type, inquireCar);
				new AdminView().functionView(userID);
				break;
			case 2:
				new StartView().start();
				break;
			default:
				System.out.println("�������󣡣���");
				login(type);
				break;
			}
		}
		return userID;
	}

	public long loginView(int type) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("======��¼======>>>");
		System.out.println("�������û�����");
		String userName = scanner.next();

		System.out.println("���������룺");
		String passWord = scanner.next();
		System.out.println("==================");
		User user = new UserServiceImpl().login(userName);
		if (user == null) {
			System.out.println("�û��������ڣ�");
			relogin(type);
		} else if (!user.getPassWord().equals(passWord)) {
			System.out.println("�û������������");
			relogin(type);
		} else if (user.getType() != type) {
			System.out.println("�û���ɫ����δ��ý�ɫȨ��");
			relogin(type);
		} else {
			System.out.println("��½�ɹ�����ӭ����" + userName);
		}
		return user.getId();
	}

	public void relogin(int type) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("========��½ʧ�ܣ�========");
		System.out.println("====�Ƿ����µ�½��(Y \\ N)====");
		String choose = scanner.next();
		if (choose.equalsIgnoreCase("y")) {
			login(type);
		} else {
			new StartView().start();
		}
	}

}
