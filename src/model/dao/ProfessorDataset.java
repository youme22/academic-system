package model.dao;

import java.util.HashMap;

import model.vo.ProfessorVO;

public class ProfessorDataset {

	public static HashMap<Integer, ProfessorVO> professorList = new HashMap<Integer, ProfessorVO>();
	
	public static void professorData() {
		professorList.put(1000, new ProfessorVO(1000, "�̹���"));
		professorList.put(2000, new ProfessorVO(2000, "���ҿ�"));
		professorList.put(3000, new ProfessorVO(3000, "������"));
		professorList.put(4000, new ProfessorVO(4000, "���ü�"));
		professorList.put(5000, new ProfessorVO(5000, "�賲��"));
		professorList.put(1111, new ProfessorVO(1111, "ȫ�浿"));
	}

}
