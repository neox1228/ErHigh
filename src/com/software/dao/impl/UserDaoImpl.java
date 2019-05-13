package com.software.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.software.dao.IUserDao;
import com.software.entity.User;
import com.software.util.JDBCTemplate;
import com.software.util.PreperedStatmentSetter;
import com.software.util.ResultSetHandler;

/**
 * 类说明
 * @author Neo
 * @version 创建时间：2019年5月6日 上午11:16:33 
 */
public class UserDaoImpl extends JDBCTemplate implements IUserDao {
	
	@Override
	public List<User> getUser(String userName) throws SQLException {

		List<User> queryList = new ArrayList<User>();
		if (userName == null) {
			String sql = "select * from t_user";
			query(sql, null, new ResultSetHandler() {

				@Override
				public void handlerRs(ResultSet rs) throws SQLException {
					if (rs.next()) {
						User user = new User(
								rs.getLong(1),
								rs.getString(2), 
								rs.getString(3), 
								rs.getInt(4), 
								rs.getString(5), 
								rs.getString(6), 
								rs.getString(7),
								rs.getInt(8));						
						queryList.add(user);
					}

				}
			});
		}else {
			String sql = "select * from t_user where username = ?";
			query(sql, new PreperedStatmentSetter() {

				@Override
				public void setvalues(PreparedStatement pstmt) throws SQLException {

					pstmt.setString(1, userName);

				}
			}, new ResultSetHandler() {

				@Override
				public void handlerRs(ResultSet rs) throws SQLException {
					if (rs.next()) {
						User user = new User(
								rs.getLong(1),
								rs.getString(2), 
								rs.getString(3), 
								rs.getInt(4), 
								rs.getString(5), 
								rs.getString(6), 
								rs.getString(7),
								rs.getInt(8));						
						queryList.add(user);
					}

				}
			});
		}	
		return queryList;
	}

	@Override
	public int addUser(User user) throws SQLException {
		String sql = "insert into t_user values (t_user_id_seq.nextval, ?, ?, ?, ?, ?, ?, 0)";
		int row = update(sql, new PreperedStatmentSetter() {
			
			@Override
			public void setvalues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, user.getPassWord());
				pstmt.setInt(3, user.getSex());
				pstmt.setString(4, user.getIdNumber());
				pstmt.setString(5, user.getTel());
				pstmt.setString(6, user.getAddr());
			}
		});
		return row;
	}

}
