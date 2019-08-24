package hnu.mn.service;

import hnu.mn.pojo.LoginUser;

public interface PermissionService {
	//根据后台接受到的dataName和dataCol（已经验证了）
	//去查询数据库，如果数据库里有，则更新
	//没有则创建
	//对应LoginPermissionMapper
	LoginUser selByLoginUser(LoginUser loginUser);
	
	int insLoginUser(LoginUser loginUser);
	
	int updLoginUserQueryTime(LoginUser loginUser);
}
