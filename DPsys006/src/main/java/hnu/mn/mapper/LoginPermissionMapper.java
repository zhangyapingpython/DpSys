package hnu.mn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hnu.mn.pojo.LoginUser;
import hnu.mn.pojo.Permission;

public interface LoginPermissionMapper {
	//根据用户ID 和 查询的数据库 查询第一次访问时间和访问次数
	LoginUser selByLoginUser(LoginUser loginUser);
	//第一次访问数据时，插入第一次访问时间和访问次数等
	int insLoginUser(LoginUser loginUser);
	
	//每进行一次查询都要在数据库中减少一次查询次数，当查询次数为0时就没
	int updLoginUserQueryNum(LoginUser loginUser);
	
	//清除已经修改过角色的用户的记录
	int delLoginUser(@Param("userID") int userID);
}

