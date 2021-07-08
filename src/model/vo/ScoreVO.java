package model.vo;

import model.dao.PreSubjectDataset;
import model.dao.ProfessorDataset;
import model.dao.StudentDataSet;

public class ScoreVO {
	private StudentVO studentVO;	// 학생 정보
	private PreSubjectVO preSubjectVO; // 지난 학기 과목 정보 
	private ProfessorVO professorVO; // 교수 정보
	private String score; 			// 학점
	
	public ScoreVO() {}
	public ScoreVO(int stuNum, int preSubCode, int profId, String score) {
		StudentDataSet.studentDataSet();	// 학생 데이터 삽입 	
		PreSubjectDataset.PreSubjects();	// 지난 학기 과목 데이터 삽입
		ProfessorDataset.professorData();	// 교수 데이터 삽입
		
		this.studentVO = StudentDataSet.list.get(stuNum);
		this.preSubjectVO = PreSubjectDataset.preSubList.get(preSubCode);
		this.professorVO = ProfessorDataset.professorList.get(profId);
		this.score = score;
	}
	public StudentVO getStudentVO() {
		return studentVO;
	}
	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	public PreSubjectVO getPreSubjectVO() {
		return preSubjectVO;
	}
	public void setPreSubjectVO(PreSubjectVO preSubjectVO) {
		this.preSubjectVO = preSubjectVO;
	}
	public ProfessorVO getProfessorVO() {
		return professorVO;
	}
	public void setProfessorVO(ProfessorVO professorVO) {
		this.professorVO = professorVO;
	}

	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

}
