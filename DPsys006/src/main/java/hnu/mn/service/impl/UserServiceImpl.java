package hnu.mn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hnu.mn.mapper.PermissionMapper;
import hnu.mn.mapper.RoleMapper;
import hnu.mn.mapper.UserMapper;
import hnu.mn.pojo.Permission;
import hnu.mn.pojo.Role;
import hnu.mn.pojo.User;
import hnu.mn.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	UserMapper usermapper;
	@Resource
	RoleMapper roleMapper;
	@Resource
	PermissionMapper permissionMapper;

	
	@Override
	public User login(User getFormUser) {
		User user=usermapper.selByUsernamePassword(getFormUser);
		if (user!=null) {
			int roleID = roleMapper.selByUserID(user.getUserID());
			Role role = roleMapper.selByRoleID4RoleName(roleID);
			user.setRole(role);
			List<Permission> permissions = permissionMapper.selByRoleId4Permisson(roleID);
			role.setPermission(permissions);
			user.setRole(role);
		
		}
		
		return user;
	}

}
