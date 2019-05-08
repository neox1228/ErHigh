package com.software.view;

import java.util.List;
import java.util.Map;
import com.software.service.impl.CarServiceImpl;

public class QueryView {
	public void queryResult(int type) {
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		Map<String, List<String>> inquireCar = carServiceImpl.inquireCar(1, type, null);
		System.out.println("编号\t汽车名称\t备注\t品牌\t类型\t价格\t是否可租");
		for(List<String> list:inquireCar.values()) {
			System.out.println(list.get(0)+"\t"+list.get(1)+"\t"+list.get(2)+"\t"+list.get(3)+"\t"+list.get(4)+"\t"+list.get(5)+"\t"+list.get(6));
		}
	}

}
