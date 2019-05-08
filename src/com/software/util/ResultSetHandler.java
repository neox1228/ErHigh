package com.software.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler {
	public void handlerRs(ResultSet rs) throws SQLException;

}
