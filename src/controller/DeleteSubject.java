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
   public void showRegisterSubject() {   // 수강내역 조회
      Iterator<Integer> keys = CourseRegistrationDataset.registerCourseList.keySet().iterator();
      
      System.out.println("\n[ 수강내역 ]\n");
      System.out.println("교과구분 \t\t 과목코드 \t\t 과목명 \t\t 이수학점 \t\t 강의교시 \t\t 교수이름");
      System.out.println("---------------------------------------------------------------------------------------------------");
      
      
      while(keys.hasNext()) {
         OpeningSubjectVO registerSubVO = OpeningSubjectDataset.oSubjectList.get(keys.next());
         System.out.printf("%-10s %10s %15s %10d %20s %10s\n", registerSubVO.getSubCurriculum(), registerSubVO.getSubCode(), registerSubVO.getSubName(), registerSubVO. getSubCredit(), registerSubVO.getSubTime(), registerSubVO.getProfessorVO().getProfessorName());
      }      
   }
   
   public void RemoveSubject() { // 수강과목 삭제

      try {
         int scSubCode = Integer.parseInt(ConInput("\n삭제할 강의코드를 입력해주세요"));
         OpeningSubjectVO registerSubVO = OpeningSubjectDataset.oSubjectList.get(scSubCode);
         if(CourseRegistrationDataset.registerCourseList.containsKey(scSubCode)) {
            CourseRegistrationDataset.registerCourseList.remove(scSubCode);
            registerSubVO.setSubNowNum(registerSubVO.getSubNowNum()-1); // 삭제할 강의에서 신청인원 -1 하기
            CourseRegistrationVO.nowCredit -= registerSubVO.getSubCredit(); // 현재수강학점에서 삭제할 수강학점 빼기
            
            System.out.println("정상적으로 삭제되었습니다.");
            showRegisterSubject();
         }else {   
            System.out.println("잘못된 강의코드 입니다. ");
            RemoveSubject();
         }
      }catch(NumberFormatException e) {
         System.out.println("잘못된 강의코드 입니다.");
            RemoveSubject();   
      }
   }
   public static String ConInput(String msg) {
      System.out.println(msg +" : ");
      return sc.nextLine();
   }     
}