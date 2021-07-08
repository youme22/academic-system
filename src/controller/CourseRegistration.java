package controller;
import java.util.Iterator;
import java.util.Scanner;

import model.dao.CourseRegistrationDataset;
import model.dao.OpeningSubjectDataset;
import model.dao.StudentDataSet;
import model.vo.CourseRegistrationVO;
import model.vo.OpeningSubjectVO;

public class CourseRegistration {
	public Scanner sc = new Scanner(System.in);

	public void showAllOpeningSubject() { // 수강시간표 조회
		Iterator<Integer> keys = OpeningSubjectDataset.oSubjectList.keySet().iterator();
		
		System.out.println("[ 수강시간표 ]\n");
		System.out.println("과목코드 \t\t 과목명 \t\t 교과구분 \t\t 강의시간 \t\t 개설학과   \t 개설학년 \t 이수학점  \t담당교수   \t정원 \t 신청인원");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
		while(keys.hasNext()) {
			OpeningSubjectVO subVO = OpeningSubjectDataset.oSubjectList.get(keys.next());
			
			System.out.printf("%-10d %10s %10s %15s %15s %10d %10d %15s %10d %10d\n"
					, subVO.getSubCode(), subVO.getSubName(), subVO.getSubCurriculum(), subVO.getSubTime(), subVO.getMajorVO().getMajorName(), subVO.getSubGrade()
					, subVO.getSubCredit(), subVO.getProfessorVO().getProfessorName(), subVO.getSubMaxNum(), subVO.getSubNowNum());
		}		
	}
	
	public void showRegisterSubject() {	// 수강내역 조회
		Iterator<Integer> keys = CourseRegistrationDataset.registerCourseList.keySet().iterator();
		
		System.out.println("\n[ 수강내역 ]\n");
		System.out.println("교과구분 \t\t 과목코드 \t\t 과목명 \t\t 이수학점 \t\t 강의교시 \t\t 교수이름");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		
		while(keys.hasNext()) {
			OpeningSubjectVO registerSubVO = OpeningSubjectDataset.oSubjectList.get(keys.next());
			System.out.printf("%-10s %10s %15s %10d %20s %10s\n", registerSubVO.getSubCurriculum(), registerSubVO.getSubCode(), registerSubVO.getSubName(), registerSubVO. getSubCredit(), registerSubVO.getSubTime(), registerSubVO.getProfessorVO().getProfessorName());
		}		
	}
	
	public void stuNumCheck(int subCode) { // 정원 초과 검사
		OpeningSubjectVO registerSubVO = OpeningSubjectDataset.oSubjectList.get(subCode);
		
		if(registerSubVO.getSubNowNum() < registerSubVO.getSubMaxNum()) {
			CourseRegistrationDataset.registerCourseList.put(subCode, registerSubVO);
			System.out.println("수강신청 성공!!");
			
			registerSubVO.setSubNowNum(registerSubVO.getSubNowNum()+1); // 신청인원 추가
			CourseRegistrationVO.nowCredit += registerSubVO.getSubCredit(); // 현재 수강학점 추가
		}
		else {
			System.out.println("정원이 초과되었습니다.");
		}
	}
	
	public int maxCreditCheck(int stuNum) { // 최대수강학점 초과여부 확인
		StudentDataSet.studentDataSet(); // 학생정보 데이터 삽입
		
		if(CourseRegistrationVO.nowCredit >= StudentDataSet.list.get(stuNum).getStuMaxCredit()) {
			System.out.println("\n최대 수강학점을 초과하셨습니다.");
			return 0;
		}
		return 1;
	}
	
	public void registerCourse(CourseRegistration cr, int stuNum) { // 수강신청
		int creditCheck;
		int subCode;
		
		creditCheck = cr.maxCreditCheck(stuNum); // 최대수강학점 초과여부 확인
		if(creditCheck == 0) return;
		
		while(true) {			
			try {
				System.out.print("\n수강 신청할 과목코드를 입력하세요: ");
				subCode = sc.nextInt();
				
				if(CourseRegistrationDataset.registerCourseList.get(subCode) != null) { // 중복 수강신청 확인
					System.out.println("이미 신청한 과목입니다.");
					break;
				}
				cr.stuNumCheck(subCode); // 정원 초과 검사
				break;
			} catch(Exception e){ // 존재하지 않는 과목코드 입력 예외처리
				System.out.print("존재하지 않는 과목 코드입니다.");
				sc = new Scanner(System.in);
			}
		}
	}
	
	public void courseRegistrationMain(CourseRegistration cr, int stuNum) { // 메인메소드
		OpeningSubjectDataset.openingSubjectData(); // 개설과목 데이터 삽입
		OpeningSubjectDataset.insertNum++;
		
		cr.showAllOpeningSubject(); // 수강시간표 조회 
		
		cr.registerCourse(cr, stuNum); // 수강신청
		
		System.out.println("\n수강신청이 종료됩니다.");
		cr.showRegisterSubject(); // 수강내역 조회
		
		
	}
}
