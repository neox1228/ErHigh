package com.software.dao;

import java.sql.SQLException;
import java.util.List;

import com.software.entity.Brand;

public interface IBrandDao {
	public List<Brand> getBrand() throws SQLException;

}
