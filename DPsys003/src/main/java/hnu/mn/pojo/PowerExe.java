package hnu.mn.pojo;

public class PowerExe {
	// 可执行权限
	private int powerExeID;
	// 查询时间，分钟
	private int queryTime;
	// 查询次数
	private int queryNum;
	// 查询噪音
	private int noiseLevel;

	@Override
	public String toString() {
		return "PowerExe [powerExeID=" + powerExeID + ", queryTime=" + queryTime + ", queryNum=" + queryNum
				+ ", noiseLevel=" + noiseLevel + "]";
	}

	public int getPowerExeID() {
		return powerExeID;
	}

	public void setPowerExeID(int powerExeID) {
		this.powerExeID = powerExeID;
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

	public int getNoiseLevel() {
		return noiseLevel;
	}

	public void setNoiseLevel(int noiseLevel) {
		this.noiseLevel = noiseLevel;
	}

}
