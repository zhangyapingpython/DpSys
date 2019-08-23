package hnu.mn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hnu.mn.pojo.Role;
import hnu.mn.pojo.UserRole;

public interface RoleMapper {
	List<UserRole> selByUserId(@Param("userId") int userId);
	//获取角色
	List<Role> selByRoleID(@Param("roleID") int roleId);
}
