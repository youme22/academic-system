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

	public void showAllOpeningSubject() { // �����ð�ǥ ��ȸ
		Iterator<Integer> keys = OpeningSubjectDataset.oSubjectList.keySet().iterator();
		
		System.out.println("[ �����ð�ǥ ]\n");
		System.out.println("�����ڵ� \t\t ����� \t\t �������� \t\t ���ǽð� \t\t �����а�   \t �����г� \t �̼�����  \t��米��   \t���� \t ��û�ο�");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
		while(keys.hasNext()) {
			OpeningSubjectVO subVO = OpeningSubjectDataset.oSubjectList.get(keys.next());
			
			System.out.printf("%-10d %10s %10s %15s %15s %10d %10d %15s %10d %10d\n"
					, subVO.getSubCode(), subVO.getSubName(), subVO.getSubCurriculum(), subVO.getSubTime(), subVO.getMajorVO().getMajorName(), subVO.getSubGrade()
					, subVO.getSubCredit(), subVO.getProfessorVO().getProfessorName(), subVO.getSubMaxNum(), subVO.getSubNowNum());
		}		
	}
	
	public void showRegisterSubject() {	// �������� ��ȸ
		Iterator<Integer> keys = CourseRegistrationDataset.registerCourseList.keySet().iterator();
		
		System.out.println("\n[ �������� ]\n");
		System.out.println("�������� \t\t �����ڵ� \t\t ����� \t\t �̼����� \t\t ���Ǳ��� \t\t �����̸�");
		System.out.println("---------------------------------------------------------------------------------------------------");
		
		
		while(keys.hasNext()) {
			OpeningSubjectVO registerSubVO = OpeningSubjectDataset.oSubjectList.get(keys.next());
			System.out.printf("%-10s %10s %15s %10d %20s %10s\n", registerSubVO.getSubCurriculum(), registerSubVO.getSubCode(), registerSubVO.getSubName(), registerSubVO. getSubCredit(), registerSubVO.getSubTime(), registerSubVO.getProfessorVO().getProfessorName());
		}		
	}
	
	public void stuNumCheck(int subCode) { // ���� �ʰ� �˻�
		OpeningSubjectVO registerSubVO = OpeningSubjectDataset.oSubjectList.get(subCode);
		
		if(registerSubVO.getSubNowNum() < registerSubVO.getSubMaxNum()) {
			CourseRegistrationDataset.registerCourseList.put(subCode, registerSubVO);
			System.out.println("������û ����!!");
			
			registerSubVO.setSubNowNum(registerSubVO.getSubNowNum()+1); // ��û�ο� �߰�
			CourseRegistrationVO.nowCredit += registerSubVO.getSubCredit(); // ���� �������� �߰�
		}
		else {
			System.out.println("������ �ʰ��Ǿ����ϴ�.");
		}
	}
	
	public int maxCreditCheck(int stuNum) { // �ִ�������� �ʰ����� Ȯ��
		StudentDataSet.studentDataSet(); // �л����� ������ ����
		
		if(CourseRegistrationVO.nowCredit >= StudentDataSet.list.get(stuNum).getStuMaxCredit()) {
			System.out.println("\n�ִ� ���������� �ʰ��ϼ̽��ϴ�.");
			return 0;
		}
		return 1;
	}
	
	public void registerCourse(CourseRegistration cr, int stuNum) { // ������û
		int creditCheck;
		int subCode;
		
		creditCheck = cr.maxCreditCheck(stuNum); // �ִ�������� �ʰ����� Ȯ��
		if(creditCheck == 0) return;
		
		while(true) {			
			try {
				System.out.print("\n���� ��û�� �����ڵ带 �Է��ϼ���: ");
				subCode = sc.nextInt();
				
				if(CourseRegistrationDataset.registerCourseList.get(subCode) != null) { // �ߺ� ������û Ȯ��
					System.out.println("�̹� ��û�� �����Դϴ�.");
					break;
				}
				cr.stuNumCheck(subCode); // ���� �ʰ� �˻�
				break;
			} catch(Exception e){ // �������� �ʴ� �����ڵ� �Է� ����ó��
				System.out.print("�������� �ʴ� ���� �ڵ��Դϴ�.");
				sc = new Scanner(System.in);
			}
		}
	}
	
	public void courseRegistrationMain(CourseRegistration cr, int stuNum) { // ���θ޼ҵ�
		OpeningSubjectDataset.openingSubjectData(); // �������� ������ ����
		OpeningSubjectDataset.insertNum++;
		
		cr.showAllOpeningSubject(); // �����ð�ǥ ��ȸ 
		
		cr.registerCourse(cr, stuNum); // ������û
		
		System.out.println("\n������û�� ����˴ϴ�.");
		cr.showRegisterSubject(); // �������� ��ȸ
		
		
	}
}
