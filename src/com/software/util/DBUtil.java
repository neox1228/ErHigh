package com.software.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//
	public static void close(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		conn.close();
	}
	public static void close(Statement stmt, Connection conn) throws SQLException {
		close(null, stmt, conn);
	}

}
