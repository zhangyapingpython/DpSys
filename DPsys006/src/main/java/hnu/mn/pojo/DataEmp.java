package hnu.mn.pojo;

public class DataEmp {
	// Data开头的都代表数据
	private int id;
	private String name;
	private int age;
	private long money;

	@Override
	public String toString() {
		return "DataEmp [id=" + id + ", name=" + name + ", age=" + age + ", money=" + money + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

}
