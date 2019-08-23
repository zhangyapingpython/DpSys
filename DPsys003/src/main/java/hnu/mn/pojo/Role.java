package hnu.mn.pojo;

public class Role {
	private int roleID;
	// 角色名字
	private String roleName;

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName + "]";
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
