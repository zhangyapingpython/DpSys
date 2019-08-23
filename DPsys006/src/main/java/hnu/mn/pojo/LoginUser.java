package hnu.mn.pojo;
//记录登陆的用户所有信息  主要作为查询次数和查询时间来使用

import java.sql.Timestamp;

public class LoginUser {
	//用户ID ， 名字 ， 可查询时间范围(单位分钟) ，
	//第一次查询时间 ，可查询次数，数据表名称
	//可以通过userID和dataName表确定操作用户的queryTime和queryNum
	int userID;
	String userName;
	long queryTime;
	Timestamp firstTime;
	int queryNum;
	String dataName;
	
}
