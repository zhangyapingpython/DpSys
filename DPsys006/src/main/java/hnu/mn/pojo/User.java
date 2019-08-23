package hnu.mn.pojo;

public class User {
	private int userID;
	private String userAccount;
	private String username;
	private String password;
	private String telphone;
	private String email;
	private char locked;

	@Override
	public String toString() {
		return "User [id=" + userID + ", userAccount=" + userAccount + ", username=" + username + ", password=" + password
				+ ", telphone=" + telphone + ", email=" + email + ", locked=" + locked + "]";
	}

	public int getId() {
		return userID;
	}

	public void setId(int id) {
		this.userID = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getLocked() {
		return locked;
	}

	public void setLocked(char locked) {
		this.locked = locked;
	}

}
