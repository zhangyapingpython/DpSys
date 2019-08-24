package hnu.mn.mapper;

import hnu.mn.pojo.LoginUser;

public interface LoginPermissionMapper {
	//根据用户ID 和 查询的数据库 查询第一次访问时间和访问次数
	LoginUser selByLoginUser(LoginUser loginUser);
	//第一次访问数据时，插入第一次访问时间和访问次数等
	int insLoginUser(LoginUser loginUser);
	
	//每进行一次查询都要在数据库中减少一次查询次数，当查询次数为0时就没
	int updLoginUserQueryNum(LoginUser loginUser);
}

