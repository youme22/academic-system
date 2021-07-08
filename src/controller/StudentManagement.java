package controller;


import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import model.dao.StudentDataSet;
import model.vo.StudentVO;

public class StudentManagement {
	Scanner sc = new Scanner(System.in);

	public void showStudentMember() {
		TreeMap<Integer, StudentVO> StuList = new TreeMap<Integer, StudentVO>(StudentDataSet.list);
		Set<Integer> key = StuList.keySet();
		
		System.out.println(" 총 " +key.size()+"명이 등록되어있습니다.\n");
		System.out.println("   학번 \t\t 이름 \t\t 전공");
		
		Iterator<Integer> keyList = key.iterator();
		while(keyList.hasNext()) {
			StudentVO vo = StuList.get(keyList.next());
			System.out.printf("%8d %10s %15s \n", vo.getStuNum(),vo.getStuName(),vo.getStuMajor());			
		}
	}
	
	  public void studentResister() {
	      StudentVO vo = new StudentVO();
	      int stuNum;
		      while(true) {         
		      try{
		            System.out.println("학번: ");
		            stuNum = sc.nextInt();
		            if(StudentDataSet.list.containsKey(stuNum)) {
				    	  System.out.println("이미 등록된 학번입니다.");
				    	  continue;
				      }else break;         
		         }
		         catch(InputMismatchException e) {
		            sc = new Scanner(System.in);
		            System.out.println("학번은 정수만 입력하세요!");
		            continue;
		         }
		      
		      }
		      vo.setStuNum(stuNum);
		      vo.setStuName(conInput("이름"));
		      vo.setStuMajor(conInput("전공"));
		      StudentDataSet.list.put(vo.getStuNum(), vo);
		      System.out.println("학번: "+vo.getStuNum()+" 이름: "+vo.getStuName()+" 전공: "+vo.getStuMajor()+ " 등록되었습니다!");
	}
	
		
	
	private String conInput(String msg) {
		System.out.println(msg + " : ");
		return sc.next();
	}

	public void studentRemove() {
		int stuNum;
		StudentVO vo = new StudentVO();
		System.out.println("삭제할 학생의 이름과 학번을 입력해주세요.");
		      
		while(true) {
			vo.setStuName(conInput("이름"));
			while(true) {
				try {
		            System.out.println("학번 :");
		            stuNum= sc.nextInt();
		            break;
		            }
		            catch(InputMismatchException e) {
		               sc = new Scanner(System.in);
		               System.out.println("학번은 정수만 입력하세요!");
		               continue;
		            }         
		         }      
		            vo.setStuNum(stuNum);
		            if(StudentDataSet.list.get(stuNum)==null) {
	            		System.out.println(vo.getStuNum()+"으로 검색된 학생이 없습니다.");
	            		continue;

		            }else if(StudentDataSet.list.get(stuNum)!=null) {
		            	if(StudentDataSet.list.get(stuNum).getStuName().equals(vo.getStuName())) {
		            		System.out.println(vo.getStuName()+" 의 정보가 삭제되었습니다.");
		            		StudentDataSet.list.remove(vo.getStuNum());
		            		break;
		            	}else {
			            	System.out.println("입력한 학번에 해당하는 학생이름이 아닙니다.");
			            	continue;
		            	}
		            }
			}
	}
}
