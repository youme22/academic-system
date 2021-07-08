package model.vo;

public class PreSubjectVO {
	private int preSubCode; 	// 지난 학기 수강한 과목코드
	private String preSubName;	// 지난 학기 수강한 과목명
	
	public PreSubjectVO() {}
		
	public PreSubjectVO(int preSubCode, String preSubName) {
		this.preSubCode = preSubCode;
		this.preSubName = preSubName;
	}
	
	public int getPreSubCode() {
		return preSubCode;
	}
	
	public void setPreSubCode(int preSubCode) {
		this.preSubCode = preSubCode;
	}
	
	public String getPreSubName() {
		return preSubName;
	}
	
	public void setPreSubName(String preSubName) {
		this.preSubName = preSubName;
	}
}
