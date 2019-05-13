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
		System.out.println("请输入需要租赁的汽车编号：");
		String carID = scanner.next();
		Record rentCar = recordServiceImpl.rentCar(carID, userID);
		if (rentCar != null) {
			List<Car> inquireCar = new CarServiceImpl().inquireCar(6, 0, carID);
			Car car = inquireCar.get(0);
			System.out.println("===========================================");
			System.out.println("租车成功！租车信息如下：");
			System.out.println("编号\t汽车名称\t每日租金\t备注\t品牌\t类型\t借车时间");
			System.out.println(rentCar.getId()+"\t"+car.getModel()+"\t"+
			car.getRent()+"\t"+car.getComments()+"\t"+car.getBrand()+"\t"+
		    car.getCategory()+"\t"+rentCar.getStartDate());
		}else {
			System.out.println("租车失败！是否重新租用(Y or N)：");
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
		System.out.println("请输入需要归还的汽车编号：");
		String carID = scanner.next();
		Record returnCar = recordServiceImpl.returnCar(carID, userID);
		if (returnCar != null) {
			List<Car> inquireCar = new CarServiceImpl().inquireCar(6, 1, String.valueOf(returnCar.getCarId()));
			Car car = inquireCar.get(0);
			System.out.println("===========================================");
			System.out.println("还车成功！租车记录如下：");
			System.out.println("编号\t汽车名称\t每日租金\t备注\t\t品牌\t类型\t借车时间\t还车时间");
			System.out.println(returnCar.getId()+"\t"+car.getModel()+"\t"+
			car.getRent()+"\t"+car.getComments()+"\t"+car.getBrand()+"\t"+
		    car.getCategory()+"\t"+returnCar.getStartDate()+"\t"+returnCar.getReturnDate());
		}else {
			System.out.println("还车失败！是否重新还车(Y or N)：");
			String choose = scanner.next();
			if (choose.equalsIgnoreCase("y")) {
				returnCarView(userID);
			}else {
				new UserView().functionView(userID);
			}
		}
	}

}
