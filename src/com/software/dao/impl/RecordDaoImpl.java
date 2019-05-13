package com.software.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.software.dao.IRecordDao;
import com.software.entity.Record;
import com.software.util.JDBCTemplate;
import com.software.util.PreperedStatmentSetter;
import com.software.util.ResultSetHandler;

public class RecordDaoImpl extends JDBCTemplate implements IRecordDao {

	@Override
	public int addRecord(Record record) throws SQLException {
			String sql = "insert into t_record (id, user_id, car_id, start_date, payment) values (t_record_id_seq.nextval, ?, ?, ?, ?)";
			int row = update(sql, new PreperedStatmentSetter() {
				
				@Override
				public void setvalues(PreparedStatement pstmt) throws SQLException {
					pstmt.setLong(1, record.getUserId());
					pstmt.setLong(2, record.getCarId());
					pstmt.setDate(3, record.getStartDate());
					pstmt.setDouble(4, record.getPayment());
				}
			});
		return row;
	}

	@Override
	public List<Record> getRecord(int choose, String condition) throws SQLException {
		List<Record> recordList = new ArrayList<Record>();
		String sql = querySQL(choose);
		if (condition == null) {
			query(sql, null, new ResultSetHandler() {
				
				@Override
				public void handlerRs(ResultSet rs) throws SQLException {
					while (rs.next()) {
						Record record = new Record(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6));
						record.setUserName(rs.getString(7));
						recordList.add(record);
					}	
				}
			});
		}else {
			query(sql, new PreperedStatmentSetter() {
				
				@Override
				public void setvalues(PreparedStatement pstmt) throws SQLException {
					pstmt.setLong(1, Long.parseLong(condition));
					
				}
			}, new ResultSetHandler() {
				
				@Override
				public void handlerRs(ResultSet rs) throws SQLException {
					while (rs.next()) {
						Record record = new Record(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDate(4), rs.getDate(5), rs.getDouble(6));
						record.setUserName(rs.getString(7));
						recordList.add(record);
					}
				}
			});
		}
		return recordList;
	}
	public String querySQL(int choose) {
		String sql = null;
		switch (choose) {
		case 1:
			sql = "SELECT r.ID,r.USER_ID,r.CAR_ID,r.START_DATE,r.RETURN_DATE,r.PAYMENT,u.USERNAME\r\n" + 
					"FROM T_RECORD r,T_USER u\r\n" + 
					"WHERE r.USER_ID = u.ID AND r.USER_ID = ?";
			break;
		case 2:
			sql = "SELECT r.ID,r.USER_ID,r.CAR_ID,r.START_DATE,r.RETURN_DATE,r.PAYMENT,u.USERNAME\r\n" + 
					"FROM T_RECORD r,T_USER u\r\n" + 
					"WHERE r.USER_ID = u.ID AND r.CAR_ID = ?";
			break;
		case 3:
			sql = "SELECT r.ID,r.USER_ID,r.CAR_ID,r.START_DATE,r.RETURN_DATE,r.PAYMENT,u.USERNAME\r\n" + 
					"FROM T_RECORD r,T_USER u\r\n" + 
					"WHERE r.USER_ID = u.ID";
			break;
		case 4:
			sql = "SELECT r.ID,r.USER_ID,r.CAR_ID,r.START_DATE,r.RETURN_DATE,r.PAYMENT,u.USERNAME \r\n" + 
					"FROM T_RECORD r,T_USER u \r\n" + 
					"WHERE r.USER_ID = u.ID AND r.ID = \r\n" + 
					"(SELECT \"MAX\"(ID)\r\n" + 
					"FROM T_RECORD WHERE USER_ID = ?)";
			break;
		case 5:
			sql = "SELECT r.ID,r.USER_ID,r.CAR_ID,r.START_DATE,r.RETURN_DATE,r.PAYMENT,u.USERNAME\r\n" + 
					"FROM T_RECORD r,T_USER u\r\n" + 
					"WHERE r.USER_ID = u.ID AND r.ID = ?";
			break;
		}
		return sql;
	}


	@Override
	public int update(Date date, double payment, long id) throws SQLException {
		String sql = "UPDATE T_RECORD SET RETURN_DATE = ?, PAYMENT = ? WHERE ID = ?";
		int row = update(sql, new PreperedStatmentSetter() {
			
			@Override
			public void setvalues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setDate(1,date);
				pstmt.setDouble(2, payment);
				pstmt.setLong(3,id);
			}
		});
		return row;
	} 

}
