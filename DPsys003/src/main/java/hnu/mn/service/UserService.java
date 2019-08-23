package hnu.mn.service;

import hnu.mn.pojo.User;

public interface UserService {
	//通过Form表单提交的用户信息 判断登陆，并记录权限，角色
	User login(User user);
}
