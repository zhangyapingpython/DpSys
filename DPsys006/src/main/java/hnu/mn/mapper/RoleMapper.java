package hnu.mn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import hnu.mn.pojo.Role;

public interface RoleMapper {
	//根据用户ID查找角色ID
	int selByUserID(@Param("userID") int userID);
	
	//根据角色ID查找角色，最后将信息保存在user中
	Role selByRoleID4RoleName(@Param("roleID") int roleID);
	
	//注册完用户后给与默认角色，角色ID为2
	int insUserRoleDefaultRegist(@Param("userID") int userID);
	
	//管理员查找所有角色ID
	@Select("select * from sys_role")
	List<Role> selAllRoles();
	
	
	//管理员根据userID修改用户角色
	int updModifyUserRole(@Param("roleID") int roleID,@Param("userID") int userID);
		
}
