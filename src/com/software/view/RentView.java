package com.software.view;

import java.util.List;
import java.util.Scanner;

import com.software.entity.Car;
import com.software.entity.Record;
import com.software.service.impl.CarServiceImpl;
import com.software.service.impl.RecordServiceImpl;

public class RentView {
	private RecordServiceImpl recordServiceImpl = new RecordServiceImpl();
	public void rentCarView(long userID) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ���޵�������ţ�");
		String carID = scanner.next();
		Record rentCar = recordServiceImpl.rentCar(carID, userID);
		if (rentCar != null) {
			List<Car> inquireCar = new CarServiceImpl().inquireCar(6, 0, carID);
			Car car = inquireCar.get(0);
			System.out.println("===========================================");
			System.out.println("�⳵�ɹ����⳵��Ϣ���£�");
			System.out.println("���\t��������\tÿ�����\t��ע\tƷ��\t����\t�賵ʱ��");
			System.out.println(rentCar.getId()+"\t"+car.getModel()+"\t"+
			car.getRent()+"\t"+car.getComments()+"\t"+car.getBrand()+"\t"+
		    car.getCategory()+"\t"+rentCar.getStartDate());
		}else {
			System.out.println("�⳵ʧ�ܣ��Ƿ���������(Y or N)��");
			String choose = scanner.next();
			if (choose.equalsIgnoreCase("y")) {
				rentCarView(userID);
			}else {
				new UserView().functionView(userID);
			}
		}
	}
	public void returnCarView(long userID) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ�黹��������ţ�");
		String carID = scanner.next();
		Record returnCar = recordServiceImpl.returnCar(carID, userID);
		if (returnCar != null) {
			List<Car> inquireCar = new CarServiceImpl().inquireCar(6, 1, String.valueOf(returnCar.getCarId()));
			Car car = inquireCar.get(0);
			System.out.println("===========================================");
			System.out.println("�����ɹ����⳵��¼���£�");
			System.out.println("���\t��������\tÿ�����\t��ע\t\tƷ��\t����\t�賵ʱ��\t����ʱ��");
			System.out.println(returnCar.getId()+"\t"+car.getModel()+"\t"+
			car.getRent()+"\t"+car.getComments()+"\t"+car.getBrand()+"\t"+
		    car.getCategory()+"\t"+returnCar.getStartDate()+"\t"+returnCar.getReturnDate());
		}else {
			System.out.println("����ʧ�ܣ��Ƿ����»���(Y or N)��");
			String choose = scanner.next();
			if (choose.equalsIgnoreCase("y")) {
				returnCarView(userID);
			}else {
				new UserView().functionView(userID);
			}
		}
	}

}
