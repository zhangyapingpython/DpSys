package hnu.mn.pojo;

public class PowerData {
	// 可查询数据表
	private int powerDataID;
	// 数据表名
	private String dataName;
	// 数据列，返回a,b,c；
	private String dataCol;

	@Override
	public String toString() {
		return "PowerData [powerDataID=" + powerDataID + ", dataName=" + dataName + ", dataCol=" + dataCol + "]";
	}

	public int getPowerDataID() {
		return powerDataID;
	}

	public void setPowerDataID(int powerDataID) {
		this.powerDataID = powerDataID;
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

}
