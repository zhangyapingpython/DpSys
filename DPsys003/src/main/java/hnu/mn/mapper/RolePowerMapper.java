package hnu.mn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hnu.mn.pojo.RolePower;

public interface RolePowerMapper {
	//根据角色ID查找权限ID
	List<RolePower> selByRoleId(@Param("roleId") int roleid);
}
