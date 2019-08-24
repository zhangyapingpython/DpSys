package hnu.mn.pojo;

public class MyError {
	String errorMessageString;

	@Override
	public String toString() {
		return "Error [errorMessageString=" + errorMessageString + "]";
	}

	public String getErrorMessageString() {
		return errorMessageString;
	}

	public void setErrorMessageString(String errorMessageString) {
		this.errorMessageString = errorMessageString;
	}

	public MyError(String errorMessageString) {
		//super();
		this.errorMessageString = errorMessageString;
	}

	public MyError() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	
}
