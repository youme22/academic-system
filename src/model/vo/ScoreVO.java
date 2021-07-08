package model.vo;

import model.dao.PreSubjectDataset;
import model.dao.ProfessorDataset;
import model.dao.StudentDataSet;

public class ScoreVO {
	private StudentVO studentVO;	// �л� ����
	private PreSubjectVO preSubjectVO; // ���� �б� ���� ���� 
	private ProfessorVO professorVO; // ���� ����
	private String score; 			// ����
	
	public ScoreVO() {}
	public ScoreVO(int stuNum, int preSubCode, int profId, String score) {
		StudentDataSet.studentDataSet();	// �л� ������ ���� 	
		PreSubjectDataset.PreSubjects();	// ���� �б� ���� ������ ����
		ProfessorDataset.professorData();	// ���� ������ ����
		
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
