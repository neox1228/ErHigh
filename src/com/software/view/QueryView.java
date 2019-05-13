package com.software.view;

import java.util.List;
import java.util.Scanner;

import com.software.entity.Brand;
import com.software.entity.Car;
import com.software.entity.Category;
import com.software.entity.Record;
import com.software.entity.User;
import com.software.service.impl.BrandServiceImpl;
import com.software.service.impl.CarServiceImpl;
import com.software.service.impl.CategoryServiceImpl;
import com.software.service.impl.RecordServiceImpl;
import com.software.service.impl.UserServiceImpl;

public class QueryView {
	public void queryRecordView(int type,long userID) {
		int key = -1;
		Scanner scanner = new Scanner(System.in);
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		RecordServiceImpl recordServiceImpl = new RecordServiceImpl();
		if (type == 0) {
			System.out.println("7.查看我的租车记录");
			key = 4;
		}else {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~租车记录查询~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1.查看所有租车记录");
			System.out.println("2.按用户编号查看记录");
			System.out.println("3.按汽车编号查看记录");
			System.out.println("请输入查询方式：");
			key = scanner.nextInt();
		}
		switch (key) {
		case 1:
			System.out.println("============================所有租车记录===========================");
			List<Record> allRecord = recordServiceImpl.queryRecord(3, null);
			queryRecord(type, allRecord);
			break;
		case 2:
			System.out.println("===========================按用户编号查看租车记录============================");
			List<User> userList = userServiceImpl.userList();
			System.out.println("编号\t用户名");
			for (User user : userList) {
				System.out.println(user.getId()+"\t"+user.getUserName());
			}
			System.out.println("请输入需要查询的用户编号：");
			String userId = scanner.next();
			List<Record> userRecord = recordServiceImpl.queryRecord(1,userId);
			queryRecord(type, userRecord);
			break;
		case 3:
			System.out.println("===========================按汽车编号查看租车记录============================");
			List<Car> CarId = carServiceImpl.inquireCar(1, type, null);
			System.out.println("编号\t汽车名");
			for (Car car : CarId) {
				System.out.println(car.getId()+"\t"+car.getModel());
			}
			System.out.println("请输入需要查询的汽车编号：");
			String carId = scanner.next();
			List<Record> carRecord = recordServiceImpl.queryRecord(2,carId);
			queryRecord(type, carRecord);
			break;
		case 4:
			//查看用户所有租车记录
			if (type == 0) {
				System.out.println("==========================个人租车记录===========================");
				List<Record> userAllRecord = recordServiceImpl.queryRecord(1, String.valueOf(userID));
				queryRecord(0, userAllRecord);
			}else {
				System.out.println("暂无此查询功能");
			}
			break;
		default:
			System.out.println("暂无此查询功能");
			break;
		}
		queryRecordView(type, userID);
	} 

	public void queryCarView(int type,long userID) {
		System.out.println(type);
		Scanner scanner = new Scanner(System.in);
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~汽车列表查询~~~~~~~~~~~~~~~~~~~~~~~~~~");
		if (type == 0) {
			System.out.println("0.返回上一级");
			System.out.println("1.按价格升序排序");
			System.out.println("2.按价格降序排序");
			System.out.println("3.按类型查询");
			System.out.println("4.按品牌查询");
			System.out.println("5.查看全部汽车");
		}else {
			System.out.println("0.返回上一级");
			System.out.println("1.查看全部汽车");
			System.out.println("2.按价格升序排序");
			System.out.println("3.按价格降序排序");
			System.out.println("4.按类型查询");
			System.out.println("5.按品牌查询");
			System.out.println("6.按汽车编号查看指定汽车");
		}
		System.out.println("请输入查询方式：");
		int key = scanner.nextInt();
		switch (key) {
		case 0:
			new AdminView().functionView(userID);
			break;
		case 1:
			System.out.println("=========================== 全部汽车信息 ===========================");
			List<Car> allCar = carServiceImpl.inquireCar(1, type, null);
			querycar(type, allCar);
			break;
		case 2:
			// 升序
			System.out.println("============================ 价格升序 ===========================");
			List<Car> ASCList = carServiceImpl.inquireCar(2, type, null);
			querycar(type, ASCList);
			break;
		case 3:
			// 降序
			System.out.println("============================ 价格降序 ===========================");
			List<Car> DESCList = carServiceImpl.inquireCar(3, type, null);
			querycar(type, DESCList);
			break;
		case 4:
			// 按类型
			System.out.println("=========================== 按类型查询 ===========================");
			long categoryID = queryCategory();
			List<Car> categoryList = carServiceImpl.inquireCar(4, type, String.valueOf(categoryID));
			querycar(type, categoryList);
			break;
		case 5:
			// 按品牌
			System.out.println("=========================== 按品牌查询 ===========================");
			long brandID = queryBrand();
			List<Car> brandList = carServiceImpl.inquireCar(5, type, String.valueOf(brandID));
			querycar(type, brandList);
			break;
		case 6:
			// 按照汽车编号查询
			if (type == 1) {
				System.out.println("===========================================================");
				System.out.println("请输入需要查询的汽车编号：");
				String carID = scanner.next();
				List<Car> carList = carServiceImpl.inquireCar(6, type, carID);
				querycar(type, carList);
			}else {
				System.out.println("暂无此查询功能");
			}
			break;
		default:
			System.out.println("暂无此查询功能");
			break;
		}
		queryCarView(type, userID);
	}

	public void querycar(int type, List<Car> inquireCar) {
		if (type == 0) {
			System.out.println("==============================================================");
			System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t价格\t是否可租");
			String status = "是";
			for (Car car : inquireCar) {
				if (car.getStatus() == 1) {
					status = "否";
				}
				System.out.println(car.getId() + "\t" + car.getModel() + "\t" + car.getComments() + "\t"
						+ car.getBrand() + "\t" + car.getCategory() + "\t" + car.getRent() + "\t" + status);
			}
		} else {
			System.out.println("==============================================================");
			System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t价格\t是否可租\t是否上架");
			String status = "可租";
			String useable = "上架";
			for (Car car : inquireCar) {
				if (car.getStatus() == 1) {
					status = "不可租";
				}
				if (car.getUserable() == 1) {
					useable = "下架";
				}
				System.out
						.println(car.getId() + "\t" + car.getModel() + "\t" + car.getComments() + "\t" + car.getBrand()
								+ "\t" + car.getCategory() + "\t" + car.getRent() + "\t" + status + "\t" + useable);
			}
		}
	}

	public void queryRecord(int type, List<Record> inquireRecord) {
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		if (type == 0) {
			System.out.println("编号\t汽车名称\t租金总额\t备注\t品牌\t类型\t借车时间\t还车时间");
			for (Record record : inquireRecord) {
				long carId = record.getCarId();
				List<Car> inquireCar = carServiceImpl.inquireCar(6, 1, String.valueOf(carId));
				Car car = inquireCar.get(0);
				System.out.println(record.getId() + "\t" + car.getModel() + "\t" + record.getPayment() + "\t"
						+ car.getComments() + "\t" + car.getBrand() + "\t" + car.getCategory() + "\t"
						+ record.getStartDate() + "\t" + record.getReturnDate());
			}
		} else {
			System.out.println("编号\t汽车名称\t每日租金\t租金总额\t备注\t品牌\t类型\t借车时间\t\t还车时间");
			for (Record record : inquireRecord) {
				long carId = record.getCarId();
				List<Car> inquireCar = carServiceImpl.inquireCar(6, 0, String.valueOf(carId));
				Car car = inquireCar.get(0);

				System.out.println(record.getId() + "\t" + car.getModel() + "\t" + car.getRent() + "\t"
						+ record.getPayment() + "\t" + car.getComments() + "\t" + car.getBrand() + "\t"
						+ car.getCategory() + "\t" + record.getStartDate() + "\t" + record.getReturnDate());
			}
		}
	}

	public long queryBrand() {
		List<Brand> queryBrand = new BrandServiceImpl().queryBrand();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------");
		System.out.println("品牌如下：");
		System.out.println("品牌编号\t品牌名");
		for (Brand brand : queryBrand) {
			System.out.println(brand.getId() + "\t" + brand.getName());
		}
		System.out.println("请输入品牌编号：");
		long brandId = scanner.nextLong();
		return brandId;
	}

	public long queryCategory() {
		List<Category> queryCategory = new CategoryServiceImpl().queryCategory();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------");
		System.out.println("类型如下");
		System.out.println("类型编号\t类型名");
		for (Category category : queryCategory) {
			System.out.println(category.getId() + "\t" + category.getName());
		}
		System.out.println("请输入类型编号：");
		long categoryId = scanner.nextLong();
		return categoryId;
	}
}
