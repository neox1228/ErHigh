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
			System.out.println("===========用户============");
			System.out.println("1.登陆，2.注册，3.返回上一级");
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
				System.out.println("输入有误！！！");
				login(type);
				break;
			}
			
		}else if (type == 1) {
			System.out.println("============管理员============");
			System.out.println("1.登陆，2.返回上一级");
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
				System.out.println("输入有误！！！");
				login(type);
				break;
			}
		}
		return userID;
	}

	public long loginView(int type) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("======登录======>>>");
		System.out.println("请输入用户名：");
		String userName = scanner.next();

		System.out.println("请输入密码：");
		String passWord = scanner.next();
		System.out.println("==================");
		User user = new UserServiceImpl().login(userName);
		if (user == null) {
			System.out.println("用户名不存在！");
			relogin(type);
		} else if (!user.getPassWord().equals(passWord)) {
			System.out.println("用户密码输入错误！");
			relogin(type);
		} else if (user.getType() != type) {
			System.out.println("用户角色错误，未获得角色权限");
			relogin(type);
		} else {
			System.out.println("登陆成功！欢迎您！" + userName);
		}
		return user.getId();
	}

	public void relogin(int type) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("========登陆失败！========");
		System.out.println("====是否重新登陆？(Y \\ N)====");
		String choose = scanner.next();
		if (choose.equalsIgnoreCase("y")) {
			login(type);
		} else {
			new StartView().start();
		}
	}

}
