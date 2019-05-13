package com.software.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.software.dao.ICategoryDao;
import com.software.entity.Category;
import com.software.util.JDBCTemplate;
import com.software.util.ResultSetHandler;

public class CategoryDaoImpl extends JDBCTemplate implements ICategoryDao {

	@Override
	public List<Category> getCategory() throws SQLException {
		ArrayList<Category> categoryList = new ArrayList<>();
		String sql = "select * from t_category";
		query(sql, null, new ResultSetHandler() {
			
			@Override
			public void handlerRs(ResultSet rs) throws SQLException {
				while(rs.next()) {
					Category category = new Category(rs.getLong(1), rs.getString(2));
					categoryList.add(category);
				}
			}
		});
		return categoryList;
	}

}
