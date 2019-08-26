package hnu.mn.pojo;

public class DataReturnToForm {
	// 查询结果
	double searchCount;
	double searchAvg;

	// 权限方面
	double remainQueryNum;
	int remainMin;
	int remainSecond;
	String dataName;

	// 错误
	String error;
	String info;

	


	@Override
	public String toString() {
		return "DataReturnToForm [searchCount=" + searchCount + ", searchAvg=" + searchAvg + ", remainQueryNum="
				+ remainQueryNum + ", remainMin=" + remainMin + ", remainSecond=" + remainSecond + ", dataName="
				+ dataName + ", error=" + error + ", info=" + info + "]";
	}

	public double getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(double searchCount) {
		this.searchCount = searchCount;
	}

	public double getSearchAvg() {
		return searchAvg;
	}

	public void setSearchAvg(double searchAvg) {
		this.searchAvg = searchAvg;
	}

	public double getRemainQueryNum() {
		return remainQueryNum;
	}

	public void setRemainQueryNum(double remainQueryNum) {
		this.remainQueryNum = remainQueryNum;
	}

	public int getRemainMin() {
		return remainMin;
	}

	public void setRemainMin(int remainMin) {
		this.remainMin = remainMin;
	}

	public int getRemainSecond() {
		return remainSecond;
	}

	public void setRemainSecond(int remainSecond) {
		this.remainSecond = remainSecond;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public DataReturnToForm(double searchCount, double searchAvg, double remainQueryNum, int remainMin,
			int remainSecond, String dataName, String error) {
		super();
		this.searchCount = searchCount;
		this.searchAvg = searchAvg;
		this.remainQueryNum = remainQueryNum;
		this.remainMin = remainMin;
		this.remainSecond = remainSecond;
		this.dataName = dataName;
		this.error = error;
	}

	
	
	public DataReturnToForm(double searchCount, double searchAvg, double remainQueryNum, int remainMin,
			int remainSecond, String dataName) {
		super();
		this.searchCount = searchCount;
		this.searchAvg = searchAvg;
		this.remainQueryNum = remainQueryNum;
		this.remainMin = remainMin;
		this.remainSecond = remainSecond;
		this.dataName = dataName;
	}
	

	
	public DataReturnToForm(String info) {
		super();
		this.info = info;
	}

	public DataReturnToForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
