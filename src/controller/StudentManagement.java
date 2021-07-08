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
		
		System.out.println(" �� " +key.size()+"���� ��ϵǾ��ֽ��ϴ�.\n");
		System.out.println("   �й� \t\t �̸� \t\t ����");
		
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
		            System.out.println("�й�: ");
		            stuNum = sc.nextInt();
		            if(StudentDataSet.list.containsKey(stuNum)) {
				    	  System.out.println("�̹� ��ϵ� �й��Դϴ�.");
				    	  continue;
				      }else break;         
		         }
		         catch(InputMismatchException e) {
		            sc = new Scanner(System.in);
		            System.out.println("�й��� ������ �Է��ϼ���!");
		            continue;
		         }
		      
		      }
		      vo.setStuNum(stuNum);
		      vo.setStuName(conInput("�̸�"));
		      vo.setStuMajor(conInput("����"));
		      StudentDataSet.list.put(vo.getStuNum(), vo);
		      System.out.println("�й�: "+vo.getStuNum()+" �̸�: "+vo.getStuName()+" ����: "+vo.getStuMajor()+ " ��ϵǾ����ϴ�!");
	}
	
		
	
	private String conInput(String msg) {
		System.out.println(msg + " : ");
		return sc.next();
	}

	public void studentRemove() {
		int stuNum;
		StudentVO vo = new StudentVO();
		System.out.println("������ �л��� �̸��� �й��� �Է����ּ���.");
		      
		while(true) {
			vo.setStuName(conInput("�̸�"));
			while(true) {
				try {
		            System.out.println("�й� :");
		            stuNum= sc.nextInt();
		            break;
		            }
		            catch(InputMismatchException e) {
		               sc = new Scanner(System.in);
		               System.out.println("�й��� ������ �Է��ϼ���!");
		               continue;
		            }         
		         }      
		            vo.setStuNum(stuNum);
		            if(StudentDataSet.list.get(stuNum)==null) {
	            		System.out.println(vo.getStuNum()+"���� �˻��� �л��� �����ϴ�.");
	            		continue;

		            }else if(StudentDataSet.list.get(stuNum)!=null) {
		            	if(StudentDataSet.list.get(stuNum).getStuName().equals(vo.getStuName())) {
		            		System.out.println(vo.getStuName()+" �� ������ �����Ǿ����ϴ�.");
		            		StudentDataSet.list.remove(vo.getStuNum());
		            		break;
		            	}else {
			            	System.out.println("�Է��� �й��� �ش��ϴ� �л��̸��� �ƴմϴ�.");
			            	continue;
		            	}
		            }
			}
	}
}
