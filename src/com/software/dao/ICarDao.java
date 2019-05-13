package com.software.dao;

import java.sql.SQLException;
import java.util.List;

import com.software.entity.Car;

public interface ICarDao {
	public List<Car> getCarList(int choose, int type, String condition) throws SQLException;
	public int updateAll(long id, int listNum, Object content) throws SQLException;
	public int addCar(Car car) throws SQLException;
}
