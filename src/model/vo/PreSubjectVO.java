package model.vo;

public class PreSubjectVO {
	private int preSubCode; 	// ���� �б� ������ �����ڵ�
	private String preSubName;	// ���� �б� ������ �����
	
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
