package com.software.view;

import java.util.List;
import java.util.Map;

import com.software.entity.Car;
import com.software.service.impl.CarServiceImpl;

public class QueryView {
	public void queryResult(int type) {
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		List<Car> inquireCar = carServiceImpl.inquireCar(1, type, null);
		System.out.println("���\t��������\t��ע\tƷ��\t����\t�۸�\t�Ƿ����");
		System.out.println();
		
			System.out.println(list.get(0)+"\t"+list.get(1)+"\t"+list.get(2)+"\t"+list.get(3)+"\t"+list.get(4)+"\t"+list.get(5)+"\t"+list.get(6));
	}

}
