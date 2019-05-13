package com.software.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.software.dao.impl.RecordDaoImpl;
import com.software.entity.Car;
import com.software.entity.Record;
import com.software.service.IRecordService;

public class RecordServiceImpl implements IRecordService {

	@Override
	public Record rentCar(String carID,long userID) {
		Record result = null;
		Car car = null;
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		List<Car> carList = carServiceImpl.inquireCar(6, 0, carID);
		if (carList.size()==0) {
			return result;
		}else {
			car = carList.get(0);
		}
		if (car.getUserable()== 0 && car.getStatus() == 0 ) {
			Calendar localDate = localDate();
			java.util.Date time = localDate.getTime();
			java.sql.Date startDate = new java.sql.Date(time.getTime());
			Record record = new Record(0, userID, Long.parseLong(carID), startDate, null, 0);
			RecordDaoImpl recordDaoImpl = new RecordDaoImpl();
			try {
				int re1 = recordDaoImpl.addRecord(record);
				int re2 = carServiceImpl.update(car.getId(), 3, "1");
				
				if (re1==1&& re2==1){
					List<Record> queryRecord = queryRecord(4,String.valueOf(userID));
					result = queryRecord.get(0);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}else {
			return result;
		}
	}
	@Override
	public Record returnCar(String carID,long userID) {
		Record result = null;
		Car car = null;
		CarServiceImpl carServiceImpl = new CarServiceImpl();
		List<Car> carList = carServiceImpl.inquireCar(6, 0, carID);
		if (carList.size() == 0) {
			return result;
		}else {
			car = carList.get(0);
		}
		List<Record> queryRecord = queryRecord(2, carID);
		for (Record record : queryRecord) {
			if (record.getUserId() == userID && record.getReturnDate() == null && record.getPayment() == 0 && car.getStatus() == 1) {
				long id = record.getId();	
				int updateCar = carServiceImpl.update(car.getId(), 3, "0");
				Calendar localDate = localDate();
				java.util.Date time = localDate.getTime();
				java.sql.Date returnDate = new java.sql.Date(time.getTime());
				java.sql.Date startDate = record.getStartDate();
				long ms = returnDate.getTime()-startDate.getTime();
				double day = ms/(1000*60*60*24);
				double payment = car.getRent()*day;
				int updateMess = updateMess(returnDate, payment, id);
				if (updateCar == 1 && updateMess == 1) {
					List<Record> returnRecord = queryRecord(5, String.valueOf(id));
					result = returnRecord.get(0);
				}
			}
		} 
		return result;
	}
	@Override
	public List<Record> queryRecord(int choose, String condition) {
		List<Record> records = null;
		RecordDaoImpl recordDaoImpl = new RecordDaoImpl();
		try {
			records = recordDaoImpl.getRecord(choose, condition);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}
	@Override
	public int updateMess(java.sql.Date date, double payment,long id) {
		int updateRes = -1;
		RecordDaoImpl recordDaoImpl = new RecordDaoImpl();
			try {
				updateRes = recordDaoImpl.update(date, payment, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return updateRes;
	}
	public Calendar localDate() {
		Calendar date = Calendar.getInstance(); 
		//date.setTime(new Date());
		return date;
	}
	
}
