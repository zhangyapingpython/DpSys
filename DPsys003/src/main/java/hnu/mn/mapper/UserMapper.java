package hnu.mn.mapper;

import hnu.mn.pojo.User;

public interface UserMapper {
	//通过用户名密码查找用户(ID)
	User selByUserName(User user);
	
}
