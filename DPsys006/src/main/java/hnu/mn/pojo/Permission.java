package hnu.mn.pojo;

public class Permission {
	private int permissionID;
	
	private String dataName;
	private String dataCol;

	private int queryTime;
	private int queryNum;
	private int queryNoise;

	@Override
	public String toString() {
		return "Permission [id=" + permissionID + ", dataName=" + dataName + ", dataCol=" + dataCol + ", queryTime=" + queryTime
				+ ", queryNum=" + queryNum + ", queryNoise=" + queryNoise + "]";
	}

	public int getId() {
		return permissionID;
	}

	public void setId(int id) {
		this.permissionID = id;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataCol() {
		return dataCol;
	}

	public void setDataCol(String dataCol) {
		this.dataCol = dataCol;
	}

	public int getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(int queryTime) {
		this.queryTime = queryTime;
	}

	public int getQueryNum() {
		return queryNum;
	}

	public void setQueryNum(int queryNum) {
		this.queryNum = queryNum;
	}

	public int getQueryNoise() {
		return queryNoise;
	}

	public void setQueryNoise(int queryNoise) {
		this.queryNoise = queryNoise;
	}

}
