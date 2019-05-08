package com.software.dao;

import java.sql.SQLException;
import java.util.List;

import com.software.entity.Car;

public interface ICarDao {
	public List<Car> getCarList(int choose, int type, String condition) throws SQLException;

}
