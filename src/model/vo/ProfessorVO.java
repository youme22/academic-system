package model.vo;

public class ProfessorVO {
	
	private int professorId;
	private String professorName;
	
	public ProfessorVO(int professorId, String professorName) {
		super();
		this.professorId = professorId;
		this.professorName = professorName;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
}
