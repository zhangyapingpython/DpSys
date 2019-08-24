package hnu.mn.pojo;

public class DataInfo {
	//封装了Form表单的数据
	private String dataName;
	private String dataCol;
	private int start;
	private int end;

	@Override
	public String toString() {
		return "DataInfo [dataName=" + dataName + ", dataCol=" + dataCol + ", start=" + start + ", end=" + end + "]";
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

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public DataInfo(String dataName, String dataCol, int start, int end) {
		super();
		this.dataName = dataName;
		this.dataCol = dataCol;
		this.start = start;
		this.end = end;
	}

	public DataInfo() {
	
	}
	
	

}
