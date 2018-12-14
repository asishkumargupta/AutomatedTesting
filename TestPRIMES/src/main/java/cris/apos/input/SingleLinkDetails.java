package cris.apos.input;



public class SingleLinkDetails {
	
	public String getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}
	
	public String getcategoryName() {
		return categoryName;
	}
	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getfunctionName() {
		return functionName;
	}
	public void setfunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}


	public  SingleLinkDetails () {
		testCaseId = "";
		categoryName = "";
		functionName = "";
		linkName = "";
		
	}
	private String testCaseId;
	private String categoryName;
	private String functionName;
	private String linkName;
	@Override
	public String toString() {
		return "\nSingleLinkDetails [testCaseId=" + testCaseId + ", categoryName=" + categoryName + ", functionName="
				+ functionName + ", linkName=" + linkName + "]";
	}

}