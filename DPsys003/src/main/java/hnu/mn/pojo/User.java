package hnu.mn.pojo;

import java.util.List;

public class User {
	// 用户ID
	private int userID;
	// 用户名
	private String userName;
	// 用户密码
	private String passWord;
	// 电话
	private String phone;
	// 邮件
	private String email;
	// 用户所拥有的角色名
	private List<Role> roles;
	// 用户所拥有的执行权限
	private List<PowerExe> powerExes;
	// 用户所拥有的数据权限
	private List<PowerData> powerDatas;

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", passWord=" + passWord + ", phone=" + phone
				+ ", email=" + email + ", roles=" + roles + ", powerExes=" + powerExes + ", powerDatas=" + powerDatas
				+ "]";
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<PowerExe> getPowerExes() {
		return powerExes;
	}

	public void setPowerExes(List<PowerExe> powerExes) {
		this.powerExes = powerExes;
	}

	public List<PowerData> getPowerDatas() {
		return powerDatas;
	}

	public void setPowerDatas(List<PowerData> powerDatas) {
		this.powerDatas = powerDatas;
	}

}
