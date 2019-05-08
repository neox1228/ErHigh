package com.software.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装增删改模板
 * 
 * @author Neo
 * @version 创建时间：2019年5月6日 上午9:34:14
 */
public class JDBCTemplate {

	/**
	 * 封装的更新模板
	 * 
	 * @param sql
	 *            SQL语句
	 * @param setter
	 *            是否需要向SQL语句中添加值
	 * @return (int)row 操作所影响的行数
	 * @throws SQLException
	 */
	public int update(String sql, PreperedStatmentSetter setter) throws SQLException {

		// 使用ConnectFactory类，调用getConnection()，创建数据库驱动并连接数据库
		Connection conn = ConnectFactory.getConnection();

		// 将传入的SQL语句传入数据库中
		PreparedStatement pstmt = conn.prepareStatement(sql);

		/*
		 * 若为空则不需要，反之则需要 判断SQL中是否需要设置值
		 */
		if (setter != null) {
			setter.setvalues(pstmt);
		}

		// 运行SQL语句
		int row = pstmt.executeUpdate();

		// 关闭资源
		DBUtil.close(pstmt, conn);

		// 返回值
		return row;
	}

	/**
	 * 封装的查询模板
	 * 
	 * @param sql
	 *            SQL语句
	 * @param setter
	 *            是否需要向SQL语句中添加值
	 * @param handler
	 *            是否需要对操作的返回值进行处理
	 * @throws SQLException
	 */
	public void query(String sql, PreperedStatmentSetter setter, ResultSetHandler handler) throws SQLException {

		// 使用ConnectFactory类，调用getConnection()，创建数据库驱动并连接数据库
		Connection conn = ConnectFactory.getConnection();

		// 将传入的SQL语句传入数据库中
		PreparedStatement pstmt = conn.prepareStatement(sql);

		/*
		 * 若为空则不需要，反之则需要 判断SQL中是否需要设置值
		 */
		if (setter != null) {
			setter.setvalues(pstmt);
		}

		// 运行SQL语句
		ResultSet rs = pstmt.executeQuery();

		/*
		 * 值为空，则不需要，反之亦然。 判断返回值是否需要处理
		 */
		if (handler != null) {
			handler.handlerRs(rs);
		}

		// 关闭资源
		DBUtil.close(rs, pstmt, conn);
	}

}
