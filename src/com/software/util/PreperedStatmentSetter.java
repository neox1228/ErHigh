package com.software.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreperedStatmentSetter {
	public void  setvalues(PreparedStatement pstmt) throws SQLException;

}
