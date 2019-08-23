package hnu.mn.pojo;

public class RolePermission {
	private int id;
	private int roleId;
	private int permissionId;

	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", roleId=" + roleId + ", permissionId=" + permissionId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

}
