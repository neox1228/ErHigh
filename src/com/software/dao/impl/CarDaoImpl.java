package com.software.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.software.dao.ICarDao;
import com.software.entity.Car;
import com.software.util.JDBCTemplate;
import com.software.util.PreperedStatmentSetter;
import com.software.util.ResultSetHandler;

public class CarDaoImpl extends JDBCTemplate implements ICarDao {

	@Override
	public List<Car> getCarList(int choose, int type, String condition) throws SQLException {
		List<Car> carList = new ArrayList<>();
		String sql = querySQL(choose);
		if (condition == null) {
			query(sql, new PreperedStatmentSetter() {
				
				@Override
				public void setvalues(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, type);
				}
			}, new ResultSetHandler() {

				@Override
				public void handlerRs(ResultSet rs) throws SQLException {
					while (rs.next()) {
						Car car = new Car();
						car.setId(rs.getLong(1));
						car.setModel(rs.getString(2));
						car.setComments(rs.getString(3));
						car.setBrand(rs.getString(4));
						car.setCategory(rs.getString(5));
						car.setRent(rs.getDouble(6));
						car.setStatus(rs.getInt(7));
						car.setUserable(rs.getInt(8));
						carList.add(car);
					}
				}
			});
		} else {
			query(sql, new PreperedStatmentSetter() {

				@Override
				public void setvalues(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, type);
					pstmt.setString(1, condition);

				}
			}, new ResultSetHandler() {

				@Override
				public void handlerRs(ResultSet rs) throws SQLException {
					while (rs.next()) {
						Car car = new Car();
						car.setId(rs.getLong(1));
						car.setModel(rs.getString(2));
						car.setComments(rs.getString(3));
						car.setBrand(rs.getString(4));
						car.setCategory(rs.getString(5));
						car.setRent(rs.getDouble(6));
						car.setStatus(rs.getInt(7));
						car.setUserable(rs.getInt(8));
						carList.add(car);
					}

				}
			});
		}
		return carList;
	}

	public String querySQL(int choose) {
		String sql = null;
		switch (choose) {
		case 1:
			sql = "select c1.ID, c1.MODEL, c1.T_COMMENTS,b.NAME,c2.NAME,c1.RENT,c1.STATUS,c1.USEABLE from T_CAR c1,T_BRAND b,T_CATEGORY c2 where c1.BRAND_ID = b.ID AND c1.CATEGORY_ID = c2.ID AND c1.USEABLE = 0 ORDER BY c1.ID";
			break;
		case 2:
			sql = "select c1.ID, c1.MODEL,c1.T_COMMENTS,b.NAME,c2.NAME,c1.RENT,c1.STATUS,c1.USEABLE\r\n" + 
					"from T_CAR c1,T_BRAND b,T_CATEGORY c2\r\n" + 
					"where c1.BRAND_ID = b.ID AND c1.CATEGORY_ID = c2.ID AND (c1.USEABLE = 0 or c1.USEABLE = ?) ORDER BY RENT";
			break;
		case 3:
			sql = "select c1.ID, c1.MODEL,c1.T_COMMENTS,b.NAME,c2.NAME,c1.RENT,c1.STATUS,c1.USEABLE\r\n" + 
					"from T_CAR c1,T_BRAND b,T_CATEGORY c2\r\n" + 
					"where c1.BRAND_ID = b.ID AND c1.CATEGORY_ID = c2.ID AND (c1.USEABLE = 0 or c1.USEABLE = ?) ORDER BY RENT DESC";
			break;
		case 4:
			sql = "select c1.ID, c1.MODEL,c1.T_COMMENTS,b.NAME,c2.NAME,c1.RENT,c1.STATUS,c1.USEABLE\r\n" + 
					"from T_CAR c1,T_BRAND b,T_CATEGORY c2\r\n" + 
					"where c1.BRAND_ID = b.ID AND c1.CATEGORY_ID = c2.ID AND (c1.USEABLE = 0 or c1.USEABLE = ?) AND c1.CATEGORY_ID = ? ORDER BY c1.ID";
			break;
		case 5:
			sql = "select c1.ID, c1.MODEL,c1.T_COMMENTS,b.NAME,c2.NAME,c1.RENT,c1.STATUS,c1.USEABLE\r\n" + 
					"from T_CAR c1,T_BRAND b,T_CATEGORY c2\r\n" + 
					"where c1.BRAND_ID = b.ID AND c1.CATEGORY_ID = c2.ID AND (c1.USEABLE = 0 or c1.USEABLE = ?) AND c1.BRAND_ID = ? ORDER BY c1.ID;";
			break;
		}
		return sql;
	}

}
