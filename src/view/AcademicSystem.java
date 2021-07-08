package view;
import java.util.Scanner;

import controller.CourseRegistration;
import controller.DeleteSubject;
import controller.Login;
import controller.ScoreManagement;
import controller.ShowSubject;
import controller.StudentManagement;
import model.dao.ScoreDataSet;
import model.dao.StudentDataSet;

/** 우선 임의로 설정했습니다.
 * 로그인
 * 학생 ID:171111 / PW:0419
 * 교수 ID:1111 / PW:0916
 * 관리자 ID:0000 / PW:0000
 */

public class AcademicSystem {
	int id;
	String pw;
	String menu;
	Scanner scanner = new Scanner(System.in);
	
	public AcademicSystem() { 
		ScoreDataSet.scores();
		System.out.println("환영합니다. 비트캠프 대학교 학사관리 시스템입니다.");
		
		while(true)
			mainMenu();
	}
	
	// 메인메뉴를 나타내는 메소드
	public void mainMenu() {
		try {
			System.out.println("\n학생 ID:171111 / PW:0419\n" + "교수 ID:1111 / PW:0916\n"  + "관리자 ID:0000 / PW:0000\n");
			System.out.println("아이디와 비밀번호를 입력하세요.");
			System.out.print("아이디 : ");
			id = scanner.nextInt();
			
			System.out.print("비밀번호 : ");
			pw = scanner.next().trim();	
		} catch(Exception e) {
			System.out.println();
			System.out.println("학번 또는 교직원 번호를 입력해주세요.");
			scanner = new Scanner(System.in);
			mainMenu();
		}
		Login login = new Login(id, pw);

		
		switch(login.logCheck()) {
			case 1:  
				System.out.println("\n*** 학생으로 로그인하셨습니다. ***");
				
				do {
					System.out.println("\n=====================================================================================================================================================");
					System.out.println("\n[MENU]	① 수강신청  ② 수강조회  ③ 수강삭제  ④ 성적조회  ⑤ 로그아웃  ⑥ 종료");
					System.out.print("\n메뉴를 선택하시오: ");
					menu = scanner.next().trim();
					System.out.println();
					
					switch(menu) {
					case "1" :
//						System.out.println("수강신청 호출");
						courseRegistration(login.getId());
						break;
					case "2" :
//						System.out.println("수강조회 호출");
						findSubject();
						break;
					case "3" :
//						System.out.println("수강삭제 호출");
						new DeleteSubject();
						break;
					case "4" :
//						System.out.println("성적조회 호출");
						scoreSearch(login.getId());
						break;
					case "5" :
						System.out.println("로그아웃되었습니다.");
						mainMenu();
						break;
					case "6" :
						System.out.println("시스템이 종료됩니다.");
						System.exit(0);
						break;
					default :
						System.out.println("올바르지 않은 메뉴입니다.");
						continue;
					}
				}while(menu != "6");
				
			case 2:	
				System.out.println("\n*** 교수로 로그인하셨습니다. ***");
				
				do {
					System.out.println("\n=====================================================================================================================================================");
					System.out.println("\n[MENU]	① 성적등록  ② 로그아웃  ③ 종료");
					System.out.print("\n메뉴를 선택하시오: ");
					menu = scanner.next().trim();
					System.out.println();
					
					switch(menu) {
					case "1":
						registerScore(login.getId());
						break;
					case "2":
						System.out.println("로그아웃되었습니다.");
						mainMenu();
						break;
					case "3":
						System.out.println("시스템이 종료됩니다.");
						System.exit(0);
						break;	
					default :
						System.out.println("올바르지 않은 메뉴입니다.");
						continue;	
					}
				} while(menu != "3");
				
				
			case 3: // 관리자 메뉴
				StudentDataSet.studentDataSet();
				System.out.println("\n*** 관리자로 로그인 하셨습니다. ***");
				String menu1 = "\n[menu]	① 학생등록  ② 학생조회  ③ 학생삭제  ④ 로그아웃  ⑤ 종료";
				
				int choice = 0;

				while(true) {
					System.out.println("\n=====================================================================================================================================================");
					System.out.println(menu1);
					System.out.print("\n메뉴를 선택하시오: ");
					choice = scanner.nextInt();
					System.out.println();
					
					switch(choice) {
					//학생등록 영역
					case 1:
						studentRegist();
						break;


					//학생조회 영역 
					case 2: 
						showStudentMember();
						while(true){
							System.out.println("\n① 확인");
							choice = scanner.nextInt();
							
							if(choice == 1) break;
							else System.out.println("다시 입력하시오 ");
								continue;
						}
						break;
					
					//학생정보삭제 영역	
					case 3 :
						showStudentMember();
						studentRemove(); break;
					
					//로그아웃 영역
					case 4: 
						mainMenu();
						break;
						
					case 5: 
						System.out.println("시스템이 종료됩니다.");
						System.exit(0);
						break;	
					
					default: 
						System.out.println("다시 입력하세요");
						continue;
				}
			}
			default : 
				System.out.println("\n아이디 또는 비밀번호가 맞지 않습니다. 다시 입력하세요");
				mainMenu();
		}		
	}

	
	//학생등록
	public void studentRegist() {
		StudentManagement a = new StudentManagement();
		a.studentResister();
	}
	//학생정보 지우기
	public void studentRemove() {
		StudentManagement a = new StudentManagement();
		a.studentRemove();
	}
	//학생목록
	public void showStudentMember() {
		StudentManagement a = new StudentManagement();
		a.showStudentMember();
	}
	//수강신청
	public void courseRegistration(int stuNum) {
		CourseRegistration cr1 = new CourseRegistration();
		cr1.courseRegistrationMain(cr1, stuNum);
	}
			
	// 수강조회
	public void findSubject() {
		ShowSubject ss = new ShowSubject();
		ss.findSubject();
	}
	
	//성적조회
	public void scoreSearch(int stuNum) {
		ScoreManagement rs = new ScoreManagement();
		rs.scoreSearchStuNum(stuNum);
	} 
	
	// 성적 등록
	public void registerScore(int professorId) {
		ScoreManagement rs = new ScoreManagement();
		rs.insertScore(professorId);
	}
		
	public static void main(String[] args) {
		// 학사관리 시스템 실행
		new AcademicSystem();
	}
	
}
