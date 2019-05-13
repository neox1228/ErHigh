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
			System.out.println("7.�鿴�ҵ��⳵��¼");
			key = 4;
		}else {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~�⳵��¼��ѯ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1.�鿴�����⳵��¼");
			System.out.println("2.���û���Ų鿴��¼");
			System.out.println("3.��������Ų鿴��¼");
			System.out.println("�������ѯ��ʽ��");
			key = scanner.nextInt();
		}
		switch (key) {
		case 1:
			System.out.println("============================�����⳵��¼===========================");
			List<Record> allRecord = recordServiceImpl.queryRecord(3, null);
			queryRecord(type, allRecord);
			break;
		case 2:
			System.out.println("===========================���û���Ų鿴�⳵��¼============================");
			List<User> userList = userServiceImpl.userList();
			System.out.println("���\t�û���");
			for (User user : userList) {
				System.out.println(user.getId()+"\t"+user.getUserName());
			}
			System.out.println("��������Ҫ��ѯ���û���ţ�");
			String userId = scanner.next();
			List<Record> userRecord = recordServiceImpl.queryRecord(1,userId);
			queryRecord(type, userRecord);
			break;
		case 3:
			System.out.println("===========================��������Ų鿴�⳵��¼============================");
			List<Car> CarId = carServiceImpl.inquireCar(1, type, null);
			System.out.println("���\t������");
			for (Car car : CarId) {
				System.out.println(car.getId()+"\t"+car.getModel());
			}
			System.out.println("��������Ҫ��ѯ��������ţ�");
			String carId = scanner.next();
			List<Record> carRecord = recordServiceImpl.queryRecord(2,carId);
			queryRecord(type, carRecord);
			break;
		case 4:
			//�鿴�û������⳵��¼
			if (type == 0) {
				System.out.println("==========================�����⳵��¼===========================");
				List<Record> userAllRecord = recordServiceImpl.queryRecord(1, String.valueOf(userID));
				queryRecord(0, userAllRecord);
			}else {
				System.out.println("���޴˲�ѯ����");
			}
			break;
		default:
			System.out.println("���޴˲�ѯ����");
			break;
		}
		queryRecordView(type, userID);
	} 

	public void queryCarView(int type,long userID) {
		System.out.println(type);
		Scanner scanner = new Scanner(System.in);
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~�����б��ѯ~~~~~~~~~~~~~~~~~~~~~~~~~~");
		if (type == 0) {
			System.out.println("0.������һ��");
			System.out.println("1.���۸���������");
			System.out.println("2.���۸�������");
			System.out.println("3.�����Ͳ�ѯ");
			System.out.println("4.��Ʒ�Ʋ�ѯ");
			System.out.println("5.�鿴ȫ������");
		}else {
			System.out.println("0.������һ��");
			System.out.println("1.�鿴ȫ������");
			System.out.println("2.���۸���������");
			System.out.println("3.���۸�������");
			System.out.println("4.�����Ͳ�ѯ");
			System.out.println("5.��Ʒ�Ʋ�ѯ");
			System.out.println("6.��������Ų鿴ָ������");
		}
		System.out.println("�������ѯ��ʽ��");
		int key = scanner.nextInt();
		switch (key) {
		case 0:
			new AdminView().functionView(userID);
			break;
		case 1:
			System.out.println("=========================== ȫ��������Ϣ ===========================");
			List<Car> allCar = carServiceImpl.inquireCar(1, type, null);
			querycar(type, allCar);
			break;
		case 2:
			// ����
			System.out.println("============================ �۸����� ===========================");
			List<Car> ASCList = carServiceImpl.inquireCar(2, type, null);
			querycar(type, ASCList);
			break;
		case 3:
			// ����
			System.out.println("============================ �۸��� ===========================");
			List<Car> DESCList = carServiceImpl.inquireCar(3, type, null);
			querycar(type, DESCList);
			break;
		case 4:
			// ������
			System.out.println("=========================== �����Ͳ�ѯ ===========================");
			long categoryID = queryCategory();
			List<Car> categoryList = carServiceImpl.inquireCar(4, type, String.valueOf(categoryID));
			querycar(type, categoryList);
			break;
		case 5:
			// ��Ʒ��
			System.out.println("=========================== ��Ʒ�Ʋ�ѯ ===========================");
			long brandID = queryBrand();
			List<Car> brandList = carServiceImpl.inquireCar(5, type, String.valueOf(brandID));
			querycar(type, brandList);
			break;
		case 6:
			// ����������Ų�ѯ
			if (type == 1) {
				System.out.println("===========================================================");
				System.out.println("��������Ҫ��ѯ��������ţ�");
				String carID = scanner.next();
				List<Car> carList = carServiceImpl.inquireCar(6, type, carID);
				querycar(type, carList);
			}else {
				System.out.println("���޴˲�ѯ����");
			}
			break;
		default:
			System.out.println("���޴˲�ѯ����");
			break;
		}
		queryCarView(type, userID);
	}

	public void querycar(int type, List<Car> inquireCar) {
		if (type == 0) {
			System.out.println("==============================================================");
			System.out.println("���\t��������\t��ע\tƷ��\t����\t�۸�\t�Ƿ����");
			String status = "��";
			for (Car car : inquireCar) {
				if (car.getStatus() == 1) {
					status = "��";
				}
				System.out.println(car.getId() + "\t" + car.getModel() + "\t" + car.getComments() + "\t"
						+ car.getBrand() + "\t" + car.getCategory() + "\t" + car.getRent() + "\t" + status);
			}
		} else {
			System.out.println("==============================================================");
			System.out.println("���\t��������\t��ע\tƷ��\t����\t�۸�\t�Ƿ����\t�Ƿ��ϼ�");
			String status = "����";
			String useable = "�ϼ�";
			for (Car car : inquireCar) {
				if (car.getStatus() == 1) {
					status = "������";
				}
				if (car.getUserable() == 1) {
					useable = "�¼�";
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
			System.out.println("���\t��������\t����ܶ�\t��ע\tƷ��\t����\t�賵ʱ��\t����ʱ��");
			for (Record record : inquireRecord) {
				long carId = record.getCarId();
				List<Car> inquireCar = carServiceImpl.inquireCar(6, 1, String.valueOf(carId));
				Car car = inquireCar.get(0);
				System.out.println(record.getId() + "\t" + car.getModel() + "\t" + record.getPayment() + "\t"
						+ car.getComments() + "\t" + car.getBrand() + "\t" + car.getCategory() + "\t"
						+ record.getStartDate() + "\t" + record.getReturnDate());
			}
		} else {
			System.out.println("���\t��������\tÿ�����\t����ܶ�\t��ע\tƷ��\t����\t�賵ʱ��\t\t����ʱ��");
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
		System.out.println("Ʒ�����£�");
		System.out.println("Ʒ�Ʊ��\tƷ����");
		for (Brand brand : queryBrand) {
			System.out.println(brand.getId() + "\t" + brand.getName());
		}
		System.out.println("������Ʒ�Ʊ�ţ�");
		long brandId = scanner.nextLong();
		return brandId;
	}

	public long queryCategory() {
		List<Category> queryCategory = new CategoryServiceImpl().queryCategory();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------");
		System.out.println("��������");
		System.out.println("���ͱ��\t������");
		for (Category category : queryCategory) {
			System.out.println(category.getId() + "\t" + category.getName());
		}
		System.out.println("���������ͱ�ţ�");
		long categoryId = scanner.nextLong();
		return categoryId;
	}
}
