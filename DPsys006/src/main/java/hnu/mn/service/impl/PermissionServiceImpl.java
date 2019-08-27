package hnu.mn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hnu.mn.mapper.LoginPermissionMapper;
import hnu.mn.pojo.LoginUser;
import hnu.mn.service.PermissionService;
@Service
public class PermissionServiceImpl implements PermissionService {
	@Resource
	LoginPermissionMapper loginPermissionMapper;
	
	
	@Override
	public LoginUser selByLoginUser(LoginUser loginUser) {
		// TODO Auto-generated method stub
		return loginPermissionMapper.selByLoginUser(loginUser);
	}

	@Override
	public int insLoginUser(LoginUser loginUser) {
		// TODO Auto-generated method stub
		return loginPermissionMapper.insLoginUser(loginUser);
	}

	@Override
	public int updLoginUserQueryTime(LoginUser loginUser) {
		// TODO Auto-generated method stub
		return loginPermissionMapper.updLoginUserQueryNum(loginUser);
	}

	
	//在LoginUser清除已经修改角色的记录
	@Override
	public int delFormerLoginUser(int userID) {
		// TODO Auto-generated method stub
		return loginPermissionMapper.delLoginUser(userID);
	}

}
