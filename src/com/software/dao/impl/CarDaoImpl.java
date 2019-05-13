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
					long id = Long.parseLong(condition);
					pstmt.setLong(2, id);
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

	@Override
	public int updateAll(long id, int listNum, Object content) throws SQLException {
		String sql = updateSQL(listNum);
		int row = update(sql, new PreperedStatmentSetter() {
			
			@Override
			public void setvalues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				String tempStr = String.valueOf(content);
				if (content instanceof String) {
					pstmt.setString(1, tempStr);
				}else if(content instanceof Integer) {
					pstmt.setInt(1, Integer.parseInt(tempStr));
				}else if(content instanceof Long){
					pstmt.setLong(1, Long.parseLong(tempStr));
				}else {
					pstmt.setDouble(1, Double.parseDouble(tempStr));
				}
				pstmt.setLong(2, id);
			}
		});
		return row;
	}

	@Override
	public int addCar(Car car) throws SQLException {
		String sql = "insert into t_car values (t_car_id_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		int row = update(sql, new PreperedStatmentSetter() {
			
			@Override
			public void setvalues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, car.getCarNumber());
				pstmt.setLong(2, car.getBrandId());
				pstmt.setString(3, car.getModel());
				pstmt.setString(4, car.getColor());
				pstmt.setLong(5, car.getCategoryId());
				pstmt.setString(6, car.getComments());
				pstmt.setDouble(7, car.getPrice());
				pstmt.setDouble(8, car.getRent());
				pstmt.setInt(9, car.getStatus());
				pstmt.setInt(10, car.getUserable());				
			}
		});
		return row;
	}
	public String querySQL(int choose) {
		String sql = null;
		switch (choose) {
		case 1:
			sql = "select c1.ID, c1.MODEL, c1.T_COMMENTS,b.NAME,c2.NAME,c1.RENT,c1.STATUS,c1.USEABLE from T_CAR c1,T_BRAND b,T_CATEGORY c2 where c1.BRAND_ID = b.ID AND c1.CATEGORY_ID = c2.ID AND (c1.USEABLE = 0 or c1.USEABLE = ?) ORDER BY c1.ID";
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
					"where c1.BRAND_ID = b.ID AND c1.CATEGORY_ID = c2.ID AND (c1.USEABLE = 0 or c1.USEABLE = ?) AND c1.BRAND_ID = ? ORDER BY c1.ID";
			break;
		case 6:
			sql = "select c1.ID, c1.MODEL,c1.T_COMMENTS,b.NAME,c2.NAME,c1.RENT,c1.STATUS,c1.USEABLE\r\n" + 
					"from T_CAR c1,T_BRAND b,T_CATEGORY c2\r\n" + 
					"where c1.BRAND_ID = b.ID AND c1.CATEGORY_ID = c2.ID AND (c1.USEABLE = 0 or c1.USEABLE = ?) AND c1.ID = ?";
			break;
		}
		return sql;
	}
    public String updateSQL(int choose) {
    	String sql = null;
    	switch (choose) {
		case 1:
			sql = "update t_car set rent = ? where id = ?";
			break;
		case 2:
			sql = "update t_car set useable = ? where id = ?";
			break;
		case 3:
			sql = "update t_car set status = ? where id = ?";
			break;
		case 4:
			sql = "update t_car set color = ? where id = ?";
			break;
		}
    	return sql;
    }
}
