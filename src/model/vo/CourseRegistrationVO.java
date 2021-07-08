package model.vo;
public class CourseRegistrationVO {
	private String subCrriculum; // 교과구분
	private String subCode; // 과목코드
	private String subName; // 강의 명
	private int subCredit; // 이수학점
	private String subTime; // 강의 교시
	private String profName; // 교수 이름
	public static int nowCredit; // 현재 수강 학점
	
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
