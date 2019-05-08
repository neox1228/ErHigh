package com.software.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.software.dao.IBrandDao;
import com.software.entity.Brand;
import com.software.util.JDBCTemplate;
import com.software.util.ResultSetHandler;

public class BrandDaoImpl extends JDBCTemplate implements IBrandDao {

	@Override
	public List<Brand> getBrand() throws SQLException {
		List<Brand> BrandList = new ArrayList<Brand>();
		String sql = "SELECT * FROM T_BRAND ";
		query(sql, null, new ResultSetHandler() {
			
			@Override
			public void handlerRs(ResultSet rs) throws SQLException {
				while(rs.next()) {
					Brand brand = new Brand(rs.getLong(1), rs.getString(2));
					BrandList.add(brand);
				}
			}
		});
		return BrandList;
				
	}

}
