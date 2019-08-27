package hnu.mn.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hnu.mn.mapper.PermissionMapper;
import hnu.mn.mapper.RoleMapper;
import hnu.mn.mapper.UserMapper;
import hnu.mn.pojo.Permission;
import hnu.mn.pojo.Role;
import hnu.mn.pojo.User;
import hnu.mn.pojo.UserRole;
import hnu.mn.service.ManageService;
//管理员
@Service
public class ManageServiceImpl  implements ManageService{
	@Resource
	UserMapper usermapper;
	@Resource
	RoleMapper roleMapper;
	@Resource
	PermissionMapper permissionMapper;

	
	//显示所有用户信息
	@Override
	public List<User> usersInfo() {
		List<User> users=new ArrayList<User>();
		//System.out.println("users  "+users);
		List<UserRole> userRoles = usermapper.selAllUserIDRoleID();
		//System.out.println("userRoles  "+userRoles);
		for (UserRole userRole : userRoles) {
			//获取用户ID 和角色ID
			int userID=userRole.getUserId();
			//System.out.println("userID  "+userID);
			//先获取用户
			User user = usermapper.selByUserID(userID);
			//System.out.println("user  "+user);
			//获取权限,后面的单词写错了，暂时这样
			int roleID=userRole.getRoleId();
			//System.out.println("roleID  "+roleID);
			
			Role role = roleMapper.selByRoleID4RoleName(roleID);
			user.setRole(role);
			List<Permission> permission = permissionMapper.selByRoleId4Permisson(roleID);
			//用户权限绑定
			//System.out.println("permission  "+permission);
			role.setPermission(permission);
			user.setRole(role);
			users.add(user);
		}		
		
		return users;
	}

//显示所有角色信息
	@Override
	public List<Role> allRoleAndPermissions() {
		//查role
		List<Role> roles = roleMapper.selAllRoles();
		for (Role role : roles) {
			int roleID=role.getRoleID();
			//根据RoleID去查权限
			List<Permission> permission = permissionMapper.selByRoleId4Permisson(roleID);
			role.setPermission(permission);
		}
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public int updUser4Role(int roleID,int userID) {
		return roleMapper.updModifyUserRole(roleID, userID);	
	}

}
