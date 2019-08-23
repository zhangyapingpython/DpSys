package hnu.mn.pojo;

public class RolePower {
	// 角色ID
	private int roleID;
	// 可执行权限ID
	private int powerExeID;
	// 可查询数据ID
	private int powerDataID;

	@Override
	public String toString() {
		return "RolePower [roleID=" + roleID + ", powerExeID=" + powerExeID + ", powerDataID=" + powerDataID + "]";
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getPowerExeID() {
		return powerExeID;
	}

	public void setPowerExeID(int powerExeID) {
		this.powerExeID = powerExeID;
	}

	public int getPowerDataID() {
		return powerDataID;
	}

	public void setPowerDataID(int powerDataID) {
		this.powerDataID = powerDataID;
	}

}
