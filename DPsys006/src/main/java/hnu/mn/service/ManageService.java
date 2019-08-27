package hnu.mn.service;

import java.util.List;

import hnu.mn.pojo.Role;
import hnu.mn.pojo.User;

public interface ManageService {
//管理员进行的操作，显示所有用户
	List<User> usersInfo();
	
	//查找所有角色，包括角色名
	//再根据角色名 查找角色对应的权限
	List<Role> allRoleAndPermissions();
	
	//修改角色对应的权限
	int updUser4Role(int roleID,int userID);
	
}
