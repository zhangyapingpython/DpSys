package hnu.mn.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hnu.mn.mapper.PowerDataMapper;
import hnu.mn.mapper.PowerExeMapper;
import hnu.mn.mapper.RoleMapper;
import hnu.mn.mapper.RolePowerMapper;
import hnu.mn.mapper.UserMapper;
import hnu.mn.pojo.PowerData;
import hnu.mn.pojo.PowerExe;
import hnu.mn.pojo.Role;
import hnu.mn.pojo.RolePower;
import hnu.mn.pojo.User;
import hnu.mn.pojo.UserRole;
import hnu.mn.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	UserMapper userMapper;
	@Resource
	RoleMapper roleMapper;
	@Resource
	RolePowerMapper rolePowerMapper;
	@Resource
	PowerExeMapper powerExeMapper;
	@Resource
	PowerDataMapper powerDataMapper;
	@Override
	
	public User login(User user) {
		List<Role> roles=new ArrayList<Role>();
		List<PowerExe> powerExes=new ArrayList<PowerExe>();
		List<PowerData> powerDatas=new ArrayList<PowerData>();
		User loginUser=userMapper.selByUserName(user);
		//说明有该用户，于是对该用户赋值
		if (loginUser!=null) {
			//查出用户具有的角色
			List<UserRole> userRoles = roleMapper.selByUserId(loginUser.getUserID());	
			for (UserRole userRole : userRoles) {
				roles.addAll(roleMapper.selByRoleID(userRole.getRoleID()));
				List<RolePower> rolePowers = rolePowerMapper.selByRoleId(userRole.getRoleID());
				for (RolePower rolePower : rolePowers) {
					powerExes.addAll(powerExeMapper.selByPowerExeID(rolePower.getPowerExeID()));
					powerDatas.addAll(powerDataMapper.selByPowerDataID(rolePower.getPowerDataID()));
				}
			}
			loginUser.setRoles(roles);
			loginUser.setPowerExes(powerExes);
			loginUser.setPowerDatas(powerDatas);
			System.out.println(loginUser);
			return loginUser;
		}else {
			return null;
		}
	}
	
	
	
	
	
}
