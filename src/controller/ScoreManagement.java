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
	int stuNum = 0;			// �й�
	String score;			// ����
	String menu;
	Scanner scanner = new Scanner(System.in);
	
	public ScoreManagement() {}
	
	// ������ ����ϴ� �޼ҵ�
	public void insertScore(int professorId) {
		ProfessorDataset.professorData(); // ���� ������ ����
		ProfessorVO professorInfo = ProfessorDataset.professorList.get(professorId);
		
		System.out.println(professorInfo.getProfessorName() + " ������ ������ ����Դϴ�.\n");
		showScores();
		stuNumCheck();
		
		while(true) {
			ScoreVO searchedStudent = ScoreDataSet.scoreList.get(stuNum);
			if(searchedStudent == null) {
				System.out.println("\n���� �й��Դϴ�. �ٽ� �Է��ϼ���");
				insertScore(professorId);
				break;
			}else {
				System.out.println("\n��ȸ�� �л� ����-------------------\n");
				System.out.println("�й�: " + searchedStudent.getStudentVO().getStuNum());
				System.out.println("�̸�: " + searchedStudent.getStudentVO().getStuName());
				System.out.println("���� �ڵ�: " + searchedStudent.getPreSubjectVO().getPreSubCode());
				System.out.println("�����: " + searchedStudent.getPreSubjectVO().getPreSubName());
				scoreCheck();
				searchedStudent.setScore(score);
				System.out.println(searchedStudent.getStudentVO().getStuName() + " �л� ������ �ԷµǾ����ϴ�.\n");
				ScoreDataSet.scoreList.put(searchedStudent.getStudentVO().getStuNum(), searchedStudent);
				showScores();
				break;
			}
		}
	}
	
	// �й��� �ùٸ��� �ԷµǾ����� Ȯ���ϴ� �޼ҵ�
	public void stuNumCheck() {
		System.out.println("\n������ ����ϰ��� �ϴ� �л��� �й��� �Է��ϼ���.");
		while(true) {
			try {
				System.out.print("�й� : ");
				stuNum = scanner.nextInt();
				if(stuNum >= 100000 && stuNum <= 999999) {
					break;
				} else
					System.out.println("���� �й��Դϴ�. �ٽ� �Է��ϼ���");
					continue;
					
			}catch(InputMismatchException e) {
				scanner = new Scanner(System.in);
				System.out.println("���� �й��Դϴ�. �ٽ� �Է��ϼ���");
				continue;
			}
		}		
	}
	
	// ������ A-F������ �Է¹ް� �ϴ� �޼ҵ�	
	public void scoreCheck() {
		while(true) {
			System.out.println("\n������ �Է��ϼ���.");
			score = scanner.next();
			if(score.matches("[A-F]")) {
				break;
			} else {
				System.out.println("�ùٸ��� ���� �����Դϴ�. �ٽ� �Է��ϼ���");
				continue;
			}
		}
	}
	
	// ���� �Է� ȭ���� �����ִ� �޼ҵ�
	public void showScores() {
		
		Iterator<Integer> it = ScoreDataSet.scoreList.keySet().iterator();
		
		System.out.println(" �й� \t �л��̸� \t �����ڵ� \t ����� \t ���� \t ����");
		for(int i = 0; i < 35; i++) {
			System.out.print("��");
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
	
	// �Է¹��� �л��� ������ �����ִ� �޼ҵ�
	public void scoreSearchStuNum(int stuNum) {
		Set<Integer> key = ScoreDataSet.scoreList.keySet();
		Iterator<Integer> keyList = key.iterator();
	
		int count = 0;
			try {
				System.out.println("[ ������ȸ ]\n");
				System.out.println("�й�\t�л��̸�\t�����ڵ�\t�����\t����\t����");
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
				System.out.println("\n�˻� ��� �� 0���� �˻��Ǿ����ϴ�.");
				return;
			}
			System.out.println("\n �� " +count +"���� �˻��Ǿ����ϴ�.");
			
		}catch(Exception e){
			
		}	
	} 
}
