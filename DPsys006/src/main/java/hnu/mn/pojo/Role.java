package hnu.mn.pojo;

public class Role {
	private int roleID;
	private String name;
	private char available;

	@Override
	public String toString() {
		return "Role [id=" + roleID + ", name=" + name + ", available=" + available + "]";
	}

	public int getId() {
		return roleID;
	}

	public void setId(int id) {
		this.roleID = id;
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

}
