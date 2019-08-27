package hnu.mn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import hnu.mn.pojo.User;
import hnu.mn.pojo.UserRole;

public interface UserMapper {
	//根据用户名密码查找用户
	User selByUsernamePassword(User user);

	//根据注册信息注册用户
	int	insUser(User user);
	
	//检查用户Account是否可用
	User selUser2CheckUserAcount(User user);
	
	//管理员用：查找整个用户角色表，获得用户ID，角色ID，再通过用户ID，查找账号
	//通过角色ID，查找权限ID，再通过 权限ID查找权限,用select标签
	@Select("select * from sys_user_role")
	List<UserRole> selAllUserIDRoleID();
	
	//管理员用，通过用户ID 查找用户
	User selByUserID(@Param("userID") int userID);
}
