package hnu.mn.mapper;

import hnu.mn.pojo.User;

public interface UserMapper {
	//根据用户名密码查找用户
	User selByUsernamePassword(User user);
	
	//根据注册信息注册用户
	int	insUser(User user);
	
	//检查用户Account是否可用
	User selUser2CheckUserAcount(User user);
}
