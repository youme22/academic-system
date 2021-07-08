package controller;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import model.dao.ProfessorDataset;
import model.dao.ScoreDataSet;
import model.vo.ProfessorVO;
import model.vo.ScoreVO;

public class ScoreManagement {
	int stuNum = 0;			// 학번
	String score;			// 학점
	String menu;
	Scanner scanner = new Scanner(System.in);
	
	public ScoreManagement() {}
	
	// 성적을 등록하는 메소드
	public void insertScore(int professorId) {
		ProfessorDataset.professorData(); // 교수 데이터 삽입
		ProfessorVO professorInfo = ProfessorDataset.professorList.get(professorId);
		
		System.out.println(professorInfo.getProfessorName() + " 교수의 수강생 명단입니다.\n");
		showScores();
		stuNumCheck();
		
		while(true) {
			ScoreVO searchedStudent = ScoreDataSet.scoreList.get(stuNum);
			if(searchedStudent == null) {
				System.out.println("\n없는 학번입니다. 다시 입력하세요");
				insertScore(professorId);
				break;
			}else {
				System.out.println("\n조회된 학생 정보-------------------\n");
				System.out.println("학번: " + searchedStudent.getStudentVO().getStuNum());
				System.out.println("이름: " + searchedStudent.getStudentVO().getStuName());
				System.out.println("과목 코드: " + searchedStudent.getPreSubjectVO().getPreSubCode());
				System.out.println("과목명: " + searchedStudent.getPreSubjectVO().getPreSubName());
				scoreCheck();
				searchedStudent.setScore(score);
				System.out.println(searchedStudent.getStudentVO().getStuName() + " 학생 학점이 입력되었습니다.\n");
				ScoreDataSet.scoreList.put(searchedStudent.getStudentVO().getStuNum(), searchedStudent);
				showScores();
				break;
			}
		}
	}
	
	// 학번이 올바르게 입력되었는지 확인하는 메소드
	public void stuNumCheck() {
		System.out.println("\n학점을 등록하고자 하는 학생의 학번을 입력하세요.");
		while(true) {
			try {
				System.out.print("학번 : ");
				stuNum = scanner.nextInt();
				if(stuNum >= 100000 && stuNum <= 999999) {
					break;
				} else
					System.out.println("없는 학번입니다. 다시 입력하세요");
					continue;
					
			}catch(InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("없는 학번입니다. 다시 입력하세요");
				continue;
			}
		}		
	}
	
	// 학점을 A-F까지만 입력받게 하는 메소드	
	public void scoreCheck() {
		while(true) {
			System.out.println("\n학점을 입력하세요.");
			score = scanner.next();
			if(score.matches("[A-F]")) {
				break;
			} else {
				System.out.println("올바르지 않은 학점입니다. 다시 입력하세요");
				continue;
			}
		}
	}
	
	// 성적 입력 화면을 보여주는 메소드
	public void showScores() {
		
		Iterator<Integer> it = ScoreDataSet.scoreList.keySet().iterator();
		
		System.out.println(" 학번 \t 학생이름 \t 과목코드 \t 과목명 \t 교수 \t 학점");
		for(int i = 0; i < 35; i++) {
			System.out.print("ㅡ");
		}
		System.out.println();
		while(it.hasNext()) {
			ScoreVO scores = ScoreDataSet.scoreList.get(it.next());
			System.out.printf(" %d  %s \t %d \t %s \t %s \t %s \n",
					scores.getStudentVO().getStuNum(), scores.getStudentVO().getStuName(),
					scores.getPreSubjectVO().getPreSubCode(), scores.getPreSubjectVO().getPreSubName(),
					scores.getProfessorVO().getProfessorName(), scores.getScore());
		}
	}
	
	// 입력받은 학생의 성적을 보여주는 메소드
	public void scoreSearchStuNum(int stuNum) {
		Set<Integer> key = ScoreDataSet.scoreList.keySet();
		Iterator<Integer> keyList = key.iterator();
	
		int count = 0;
			try {
				System.out.println("[ 성적조회 ]\n");
				System.out.println("학번\t학생이름\t과목코드\t과목명\t교수\t성적");
				System.out.println("----------------------------------------------------");
				
			while(keyList.hasNext()) {
				
				int key1 = keyList.next();
				ScoreVO scorevo = ScoreDataSet.scoreList.get(key1);
				
				if(scorevo.getStudentVO().getStuNum() == stuNum) {	
					System.out.printf("%-5d %5s %5d %8s %5s %5s\n",
							scorevo.getStudentVO().getStuNum() , scorevo.getStudentVO().getStuName(), scorevo.getPreSubjectVO().getPreSubCode() 
							, scorevo.getPreSubjectVO().getPreSubName(), scorevo.getProfessorVO().getProfessorName(), scorevo.getScore());
					count++;
				}		
			}
			
			if(count == 0) {
				System.out.println("\n검색 결과 총 0건이 검색되었습니다.");
				return;
			}
			System.out.println("\n 총 " +count +"건이 검색되었습니다.");
			
		}catch(Exception e){
			
		}	
	} 
}
