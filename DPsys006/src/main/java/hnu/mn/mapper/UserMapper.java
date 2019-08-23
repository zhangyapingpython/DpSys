package hnu.mn.mapper;

import hnu.mn.pojo.User;

public interface UserMapper {
	//根据用户名密码查找用户
	User selByUsernamePassword(User user);
	
}
