package controller;
import java.util.Iterator;
import java.util.Scanner;

import model.dao.CourseRegistrationDataset;
import model.dao.OpeningSubjectDataset;
import model.vo.CourseRegistrationVO;
import model.vo.OpeningSubjectVO;

public class DeleteSubject {
   static Scanner sc = new Scanner(System.in);
   
   public DeleteSubject() {
             showRegisterSubject();
            RemoveSubject();
   }
   public void showRegisterSubject() {   // �������� ��ȸ
      Iterator<Integer> keys = CourseRegistrationDataset.registerCourseList.keySet().iterator();
      
      System.out.println("\n[ �������� ]\n");
      System.out.println("�������� \t\t �����ڵ� \t\t ����� \t\t �̼����� \t\t ���Ǳ��� \t\t �����̸�");
      System.out.println("---------------------------------------------------------------------------------------------------");
      
      
      while(keys.hasNext()) {
         OpeningSubjectVO registerSubVO = OpeningSubjectDataset.oSubjectList.get(keys.next());
         System.out.printf("%-10s %10s %15s %10d %20s %10s\n", registerSubVO.getSubCurriculum(), registerSubVO.getSubCode(), registerSubVO.getSubName(), registerSubVO. getSubCredit(), registerSubVO.getSubTime(), registerSubVO.getProfessorVO().getProfessorName());
      }      
   }
   
   public void RemoveSubject() { // �������� ����

      try {
         int scSubCode = Integer.parseInt(ConInput("\n������ �����ڵ带 �Է����ּ���"));
         OpeningSubjectVO registerSubVO = OpeningSubjectDataset.oSubjectList.get(scSubCode);
         if(CourseRegistrationDataset.registerCourseList.containsKey(scSubCode)) {
            CourseRegistrationDataset.registerCourseList.remove(scSubCode);
            registerSubVO.setSubNowNum(registerSubVO.getSubNowNum()-1); // ������ ���ǿ��� ��û�ο� -1 �ϱ�
            CourseRegistrationVO.nowCredit -= registerSubVO.getSubCredit(); // ��������������� ������ �������� ����
            
            System.out.println("���������� �����Ǿ����ϴ�.");
            showRegisterSubject();
         }else {   
            System.out.println("�߸��� �����ڵ� �Դϴ�. ");
            RemoveSubject();
         }
      }catch(NumberFormatException e) {
         System.out.println("�߸��� �����ڵ� �Դϴ�.");
            RemoveSubject();   
      }
   }
   public static String ConInput(String msg) {
      System.out.println(msg +" : ");
      return sc.nextLine();
   }     
}