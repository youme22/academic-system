package controller;

import java.util.Iterator;

import model.dao.CourseRegistrationDataset;
import model.dao.OpeningSubjectDataset;
import model.vo.OpeningSubjectVO;

public class ShowSubject {

	public void findSubject() {
		Iterator<Integer> keys = CourseRegistrationDataset.registerCourseList.keySet().iterator();
		
		System.out.println("[ 수강 조회 결과 ]\n");
		System.out.println("과목코드 \t\t 과목명 \t\t 교과구분 \t\t 개설학과  \t 개설학년 \t 이수학점  \t담당교수  \t\t정원 \t 신청인원");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		while(keys.hasNext()) {
		OpeningSubjectVO subVO = OpeningSubjectDataset.oSubjectList.get(keys.next());
						
		System.out.printf("%-10d %10s %13s %15s %10d %10d %15s %10d %10d\n"
			, subVO.getSubCode(), subVO.getSubName(), subVO.getSubCurriculum(), subVO.getMajorVO().getMajorName(), subVO.getSubGrade()
			, subVO.getSubCredit(), subVO.getProfessorVO().getProfessorName(), subVO.getSubMaxNum(), subVO.getSubNowNum());
		}		
	}
}