package com.software.service;

import java.util.List;

import com.software.entity.Car;


public interface ICarService {
	public List<Car> inquireCar(int choose,int type, String condition);

}
