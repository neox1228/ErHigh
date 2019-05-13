package com.software.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.software.dao.impl.BrandDaoImpl;
import com.software.entity.Brand;
import com.software.service.IBrandService;

public class BrandServiceImpl implements IBrandService{

	@Override
	public List<Brand> queryBrand() {
		List<Brand> brandList = null;
		BrandDaoImpl brandDaoImpl = new BrandDaoImpl();
		try {
			brandList = brandDaoImpl.getBrand();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brandList;
	}

}
