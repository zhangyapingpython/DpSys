package hnu.mn.pojo;

public class DataReturn {
	private int status;
	private String error;
	private String info;

	@Override
	public String toString() {
		return "DataReturn [status=" + status + ", error=" + error + ", info=" + info + "]";
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

}
