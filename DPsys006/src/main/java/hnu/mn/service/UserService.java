package hnu.mn.service;

import hnu.mn.pojo.User;

public interface UserService {
	//用户登陆
	User login(User user);
	
	//用户注册
	void insUser(User user);
	
	//注册时用户账户是否已存在
	boolean checkUserAccount(String  userAccount);
	
	//修改权限
	public User managePermisson(int userID);
}
