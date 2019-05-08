package com.software.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.software.dao.impl.CarDaoImpl;
import com.software.entity.Car;
import com.software.service.ICarService;

public class CarServiceImpl implements ICarService {

	@Override
	public List<Car> inquireCar(int choose, int type, String condition) {
		List<Car> carList = null;
		CarDaoImpl carDaoImpl = new CarDaoImpl();
		if (type == 0) {
			try {
				carList = carDaoImpl.getCarList(choose, 0, condition);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				carList = carDaoImpl.getCarList(choose, 1, condition);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return carList;
	}

}
