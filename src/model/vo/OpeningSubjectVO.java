package model.vo;

import model.dao.DepartmentDataset;
import model.dao.ProfessorDataset;

public class OpeningSubjectVO {

	private int subCode;
	private String subName;
	private String subCurriculum;
	private DepartmentVO majorVO;
	private int subGrade;
	private int subCredit;
	private ProfessorVO professorVO;
	private int subMaxNum;
	private int subNowNum;
	private String subTime;
	
	public OpeningSubjectVO(int subCode, String subName, String subCurriculum, String subTime, int majorCode, 
			int subGrade, int subCredit, int profId, int subMaxNum, int subNowNum) {
		super();
		DepartmentDataset.departmentData();	// 학과데이터 삽입
		ProfessorDataset.professorData();	// 교수데이터 삽입
		
		this.subCode = subCode;
		this.subName = subName;
		this.subCurriculum = subCurriculum;
		this.subGrade = subGrade;
		this.subCredit = subCredit;
		this.subMaxNum = subMaxNum;
		this.subNowNum = subNowNum;
		this.majorVO = DepartmentDataset.departmentList.get(majorCode);
		this.professorVO = ProfessorDataset.professorList.get(profId);
		this.subTime = subTime;
	}
	public int getSubCode() {
		return subCode;
	}
	public void setSubCode(int subCode) {
		this.subCode = subCode;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubCurriculum() {
		return subCurriculum;
	}
	public void setSubCurriculum(String subCurriculum) {
		this.subCurriculum = subCurriculum;
	}
	public DepartmentVO getMajorVO() {
		return majorVO;
	}
	public void setMajorVO(DepartmentVO majorVO) {
		this.majorVO = majorVO;
	}
	public int getSubGrade() {
		return subGrade;
	}
	public void setSubGrade(int subGrade) {
		this.subGrade = subGrade;
	}
	public int getSubCredit() {
		return subCredit;
	}
	public void setSubCredit(int subCredit) {
		this.subCredit = subCredit;
	}
	public ProfessorVO getProfessorVO() {
		return professorVO;
	}
	public void setProfessorVO(ProfessorVO professorVO) {
		this.professorVO = professorVO;
	}
	public int getSubMaxNum() {
		return subMaxNum;
	}
	public void setSubMaxNum(int subMaxNum) {
		this.subMaxNum = subMaxNum;
	}
	public int getSubNowNum() {
		return subNowNum;
	}
	public void setSubNowNum(int subNowNum) {
		this.subNowNum = subNowNum;
	}
	public String getSubTime() {
		return subTime;
	}
	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}
}
