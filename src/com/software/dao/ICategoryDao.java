package com.software.dao;

import java.sql.SQLException;
import java.util.List;

import com.software.entity.Category;

public interface ICategoryDao {
	public List<Category> getCategory() throws SQLException;

}
