package hnu.mn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hnu.mn.mapper.PermissionMapper;
import hnu.mn.mapper.RoleMapper;
import hnu.mn.mapper.UserMapper;
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
	public User login(User user) {
		
		return null;
	}

}
