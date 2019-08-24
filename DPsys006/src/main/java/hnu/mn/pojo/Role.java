package hnu.mn.pojo;

import java.util.List;

public class Role {
	private int roleID;
	private String name;
	private char available;
	//角色所拥有的权限可能不止一个
	private List<Permission> Permission;

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", name=" + name + ", available=" + available + ", Permission=" + Permission
				+ "]";
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getAvailable() {
		return available;
	}

	public void setAvailable(char available) {
		this.available = available;
	}

	public List<Permission> getPermission() {
		return Permission;
	}

	public void setPermission(List<Permission> permission) {
		Permission = permission;
	}

}
