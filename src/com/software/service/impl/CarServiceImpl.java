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
		try {
			carList = carDaoImpl.getCarList(choose, type, condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carList;
	}

	@Override
	public int update(Long id, int listNum, Object content) {
		CarDaoImpl carDaoImpl = new CarDaoImpl();
		int updateAll = -1;
			try {
				updateAll = carDaoImpl.updateAll(id, listNum, content);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return updateAll;
	}

	@Override
	public int addVehicle(Car car) {
		int result = -1;
		CarDaoImpl carDaoImpl = new CarDaoImpl();
		try {
			result = carDaoImpl.addCar(car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
