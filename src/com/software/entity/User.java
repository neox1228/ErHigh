package com.software.entity;

public class User {
	private long id;
	private String userName;
	private String passWord;
	private int sex;
	private String idNumber;
	private String tel;
	private String addr;
	private int type;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(long id, String userName, String passWord, int sex, String idNumber, String tel, String addr,
			int type) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.sex = sex;
		this.idNumber = idNumber;
		this.tel = tel;
		this.addr = addr;
		this.type = type;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", sex=" + sex + ", idNumber="
				+ idNumber + ", tel=" + tel + ", addr=" + addr + ", type=" + type + "]";
	}
	
	
}
