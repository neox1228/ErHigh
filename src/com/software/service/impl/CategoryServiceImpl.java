package com.software.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.software.dao.impl.CategoryDaoImpl;
import com.software.entity.Category;
import com.software.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	@Override
	public List<Category> queryCategory() {
		List<Category> categoryList = null;
		CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
		try {
			categoryList = categoryDaoImpl.getCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}

}
