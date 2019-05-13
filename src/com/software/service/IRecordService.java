package com.software.service;

import java.util.List;

import com.software.entity.Record;

public interface IRecordService {
	public List<Record> queryRecord(int choose, String condition);
	public Record rentCar(String carID,long userID);
	public Record returnCar(String carID,long userID);
	public int updateMess(java.sql.Date date, double payment,long id);
}
