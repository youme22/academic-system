package model.vo;
public class CourseRegistrationVO {
	private String subCrriculum; // ��������
	private String subCode; // �����ڵ�
	private String subName; // ���� ��
	private int subCredit; // �̼�����
	private String subTime; // ���� ����
	private String profName; // ���� �̸�
	public static int nowCredit; // ���� ���� ����
	
	public CourseRegistrationVO(String subCrriculum,String subCode,String subName,int subCredit,String subTime,String profName) {
		this.subCrriculum = subCrriculum;
		this.subCode = subCode;
		this.subName = subName;
		this.subCredit = subCredit;
		this.subTime = subTime;
		this.profName = profName;
	}
	
	public String getsubCrriculum() {
		return subCrriculum;
	}
	
	public void setsubCrriculum(String subCrriculum) {
		this.subCrriculum = subCrriculum;
	}

	public String getsubCode() {
		return subCode;
	}
	
	public void setsubCode(String subCode) {
		this.subCode = subCode;
	}
	
	public String getsubName() {
		return subName;
	}
	
	public void setsubName(String subName) {
		this.subName = subName;
	}
	
	public int getsubCredit() {
		return subCredit;
	}
	
	public void setsubCredit(int subCredit) {
		this.subCredit = subCredit;
	}
	
	public String getsubTime() {
		return subTime;
	}
	
	public void setsubTime(String subTime) {
		this.subTime = subTime;
	}
	
	public String getprofName() {
		return profName;
	}
	
	public void setprofName(String profName) {
		this.profName = profName;
	}
	
}
