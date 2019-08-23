package hnu.mn.mapper;

import org.apache.ibatis.annotations.Param;

import hnu.mn.pojo.Role;

public interface RoleMapper {
	//根据用户ID查找角色ID
	int selByUserID(@Param("userID") int userID);
	
	//根据角色ID查找角色名字
	Role selByRoleID4RoleName(@Param("roleID") int roleID);
	
}
