package jdbc_hikaricp;

public enum ErpType {
	TITLE("직책관리"), DEPT("부서관리"), EMP("사원관리");
	
	private String value;

	private ErpType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
