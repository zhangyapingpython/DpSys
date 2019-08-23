package hnu.mn.pojo;

public class UserRole {
	// 用户ID
	private int userID;
	// 角色ID
	private int roleID;

	@Override
	public String toString() {
		return "UserRole [userID=" + userID + ", roleID=" + roleID + "]";
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

}
