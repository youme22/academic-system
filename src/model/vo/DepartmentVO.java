package model.vo;

public class DepartmentVO {

	private int majorCode;
	private String majorName;
	
	public DepartmentVO(int majorCode, String majorName) {
		super();
		this.majorCode = majorCode;
		this.majorName = majorName;
	}
	public int getMajorCode() {
		return majorCode;
	}
	public void setMajorCode(int majorCode) {
		this.majorCode = majorCode;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
}
