package controller;

import java.util.Iterator;

import model.dao.CourseRegistrationDataset;
import model.dao.OpeningSubjectDataset;
import model.vo.OpeningSubjectVO;

public class ShowSubject {

	public void findSubject() {
		Iterator<Integer> keys = CourseRegistrationDataset.registerCourseList.keySet().iterator();
		
		System.out.println("[ ���� ��ȸ ��� ]\n");
		System.out.println("�����ڵ� \t\t ����� \t\t �������� \t\t �����а�  \t �����г� \t �̼�����  \t��米��  \t\t���� \t ��û�ο�");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		while(keys.hasNext()) {
		OpeningSubjectVO subVO = OpeningSubjectDataset.oSubjectList.get(keys.next());
						
		System.out.printf("%-10d %10s %13s %15s %10d %10d %15s %10d %10d\n"
			, subVO.getSubCode(), subVO.getSubName(), subVO.getSubCurriculum(), subVO.getMajorVO().getMajorName(), subVO.getSubGrade()
			, subVO.getSubCredit(), subVO.getProfessorVO().getProfessorName(), subVO.getSubMaxNum(), subVO.getSubNowNum());
		}		
	}
}