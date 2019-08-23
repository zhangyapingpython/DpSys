package hnu.mn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hnu.mn.pojo.Permission;

public interface PermissionMapper {
	//根据角色名直接查找权限（包括数据和操作权限）
	List<Permission> selByRoleId4Permisson(@Param("roleID") int roleID);
}
