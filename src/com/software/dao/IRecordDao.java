package com.software.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.software.entity.Record;

public interface IRecordDao {
	public List<Record> getRecord(int choose, String condition) throws SQLException;
	public int addRecord(Record record) throws SQLException;
	public int update(Date date, double payment,long id) throws SQLException; 
}
