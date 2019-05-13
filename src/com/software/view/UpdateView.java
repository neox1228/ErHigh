package com.software.view;

import java.util.List;
import java.util.Scanner;

import com.software.entity.Brand;
import com.software.entity.Car;
import com.software.entity.Category;
import com.software.service.impl.BrandServiceImpl;
import com.software.service.impl.CarServiceImpl;
import com.software.service.impl.CategoryServiceImpl;

public class UpdateView {
	public void addCar(long userID) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================添加汽车============================");
		System.out.println("=====================");
		System.out.println("请分别输入以下信息：");
		QueryView queryView = new QueryView();
		long brandId = queryView.queryBrand();
		long categoryId = queryView.queryCategory();
		System.out.println("-------------------");
		System.out.print("型号：");
		String model = scanner.next();
		System.out.println("-------------------");
		System.out.print("车牌号：");
		String carNumber = scanner.next();
		System.out.println("-------------------");
		System.out.print("概要：");
		String comments = scanner.next();
		System.out.println("-------------------");
		System.out.print("颜色：");
		String color = scanner.next();
		System.out.println("-------------------");
		System.out.print("汽车价格：");
		double price = scanner.nextDouble();
		System.out.println("-------------------");
		System.out.print("每日租金：");
		double rent = scanner.nextDouble();
		System.out.println("-------------------");
		System.out.print("是否可借(0:可借 1:不可借)：");
		int status = scanner.nextInt();
		System.out.println("-------------------");
		System.out.print("是否上架(0:上架 1:下架)：");
		int userable = scanner.nextInt();
		Car car = new Car(0, carNumber, brandId, model, color, categoryId, comments, price, rent, status, userable);
		int row = new CarServiceImpl().addVehicle(car);
		if (row>0) {
			System.out.println("汽车添加成功！");
		}else {
			System.out.println("添加失败！是否重新修改？（y or n）:");
			String next = scanner.next();
			if (next.equalsIgnoreCase("y")) {
				addCar(userID);
			}else {
				new AdminView().functionView(userID);
			}
		}
	}

	public void updateCarMess(long userID) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===========================修改汽车信息============================");
		System.out.print("请输入修改信息的汽车编号：");
		String carID = scanner.next();
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		List<Car> inquireCar = carServiceImpl.inquireCar(6, 1, carID);
		Car car = inquireCar.get(0);
		QueryView queryView = new QueryView();
		queryView.querycar(1, inquireCar);
		int row =-1;
		System.out.println("请输入要修改的内容的编号：\n1.租赁价格，2.上架下架，3.颜色");
		int choose = scanner.nextInt();
		
		if (choose == 1) {
			System.out.println("请输入新的租赁价格：");
			double newRent = scanner.nextDouble();
			row = carServiceImpl.update(Long.parseLong(carID), choose, newRent);
		}else {
			System.out.println("0.上架，1.下架：");
			int newUseable = scanner.nextInt();
			row = carServiceImpl.update(Long.parseLong(carID), choose, newUseable);
		}
		if (row > 0) {
			System.out.println("修改成功！");
			List<Car> list = carServiceImpl.inquireCar(6, 1, carID);
			queryView.querycar(1, list);
		}else {
			System.out.println("修改失败！是否重新修改？（y or n）:");
			String next = scanner.next();
			if (next.equalsIgnoreCase("y")) {
				updateCarMess(userID);
			}else {
				new AdminView().functionView(userID);
			}
		}
	}
}
