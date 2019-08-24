package hnu.mn.pojo;
//记录登陆的用户所有信息  主要作为查询次数和查询时间来使用

import java.sql.Timestamp;

public class LoginUser {
	// 用户ID ， 名字 ， 可查询时间范围(单位分钟) ，
	// 第一次查询时间 ，可查询次数，数据表名称
	// 可以通过userID和dataName表确定操作用户的queryTime和queryNum
	int userID;
	String username;
	long queryTime;
	Timestamp firstTime;
	int queryNum;
	String dataName;
	@Override
	public String toString() {
		return "LoginUser [userID=" + userID + ", username=" + username + ", queryTime=" + queryTime + ", firstTime="
				+ firstTime + ", queryNum=" + queryNum + ", dataName=" + dataName + "]";
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(long queryTime) {
		this.queryTime = queryTime;
	}
	public Timestamp getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Timestamp firstTime) {
		this.firstTime = firstTime;
	}
	public int getQueryNum() {
		return queryNum;
	}
	public void setQueryNum(int queryNum) {
		this.queryNum = queryNum;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public LoginUser(int userID, String username, long queryTime, Timestamp firstTime, int queryNum, String dataName) {
		super();
		this.userID = userID;
		this.username = username;
		this.queryTime = queryTime;
		this.firstTime = firstTime;
		this.queryNum = queryNum;
		this.dataName = dataName;
	}
	public LoginUser() {
	
	}
	
	

}
