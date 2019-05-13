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
		System.out.println("=============================�������============================");
		System.out.println("=====================");
		System.out.println("��ֱ�����������Ϣ��");
		QueryView queryView = new QueryView();
		long brandId = queryView.queryBrand();
		long categoryId = queryView.queryCategory();
		System.out.println("-------------------");
		System.out.print("�ͺţ�");
		String model = scanner.next();
		System.out.println("-------------------");
		System.out.print("���ƺţ�");
		String carNumber = scanner.next();
		System.out.println("-------------------");
		System.out.print("��Ҫ��");
		String comments = scanner.next();
		System.out.println("-------------------");
		System.out.print("��ɫ��");
		String color = scanner.next();
		System.out.println("-------------------");
		System.out.print("�����۸�");
		double price = scanner.nextDouble();
		System.out.println("-------------------");
		System.out.print("ÿ�����");
		double rent = scanner.nextDouble();
		System.out.println("-------------------");
		System.out.print("�Ƿ�ɽ�(0:�ɽ� 1:���ɽ�)��");
		int status = scanner.nextInt();
		System.out.println("-------------------");
		System.out.print("�Ƿ��ϼ�(0:�ϼ� 1:�¼�)��");
		int userable = scanner.nextInt();
		Car car = new Car(0, carNumber, brandId, model, color, categoryId, comments, price, rent, status, userable);
		int row = new CarServiceImpl().addVehicle(car);
		if (row>0) {
			System.out.println("������ӳɹ���");
		}else {
			System.out.println("���ʧ�ܣ��Ƿ������޸ģ���y or n��:");
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
		System.out.println("===========================�޸�������Ϣ============================");
		System.out.print("�������޸���Ϣ��������ţ�");
		String carID = scanner.next();
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		List<Car> inquireCar = carServiceImpl.inquireCar(6, 1, carID);
		Car car = inquireCar.get(0);
		QueryView queryView = new QueryView();
		queryView.querycar(1, inquireCar);
		int row =-1;
		System.out.println("������Ҫ�޸ĵ����ݵı�ţ�\n1.���޼۸�2.�ϼ��¼ܣ�3.��ɫ");
		int choose = scanner.nextInt();
		
		if (choose == 1) {
			System.out.println("�������µ����޼۸�");
			double newRent = scanner.nextDouble();
			row = carServiceImpl.update(Long.parseLong(carID), choose, newRent);
		}else {
			System.out.println("0.�ϼܣ�1.�¼ܣ�");
			int newUseable = scanner.nextInt();
			row = carServiceImpl.update(Long.parseLong(carID), choose, newUseable);
		}
		if (row > 0) {
			System.out.println("�޸ĳɹ���");
			List<Car> list = carServiceImpl.inquireCar(6, 1, carID);
			queryView.querycar(1, list);
		}else {
			System.out.println("�޸�ʧ�ܣ��Ƿ������޸ģ���y or n��:");
			String next = scanner.next();
			if (next.equalsIgnoreCase("y")) {
				updateCarMess(userID);
			}else {
				new AdminView().functionView(userID);
			}
		}
	}
}
