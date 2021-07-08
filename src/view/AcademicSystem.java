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

/** �켱 ���Ƿ� �����߽��ϴ�.
 * �α���
 * �л� ID:171111 / PW:0419
 * ���� ID:1111 / PW:0916
 * ������ ID:0000 / PW:0000
 */

public class AcademicSystem {
	int id;
	String pw;
	String menu;
	Scanner scanner = new Scanner(System.in);
	
	public AcademicSystem() { 
		ScoreDataSet.scores();
		System.out.println("ȯ���մϴ�. ��Ʈķ�� ���б� �л���� �ý����Դϴ�.");
		
		while(true)
			mainMenu();
	}
	
	// ���θ޴��� ��Ÿ���� �޼ҵ�
	public void mainMenu() {
		try {
			System.out.println("\n�л� ID:171111 / PW:0419\n" + "���� ID:1111 / PW:0916\n"  + "������ ID:0000 / PW:0000\n");
			System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
			System.out.print("���̵� : ");
			id = scanner.nextInt();
			
			System.out.print("��й�ȣ : ");
			pw = scanner.next().trim();	
		} catch(Exception e) {
			System.out.println();
			System.out.println("�й� �Ǵ� ������ ��ȣ�� �Է����ּ���.");
			scanner = new Scanner(System.in);
			mainMenu();
		}
		Login login = new Login(id, pw);

		
		switch(login.logCheck()) {
			case 1:  
				System.out.println("\n*** �л����� �α����ϼ̽��ϴ�. ***");
				
				do {
					System.out.println("\n=====================================================================================================================================================");
					System.out.println("\n[MENU]	�� ������û  �� ������ȸ  �� ��������  �� ������ȸ  �� �α׾ƿ�  �� ����");
					System.out.print("\n�޴��� �����Ͻÿ�: ");
					menu = scanner.next().trim();
					System.out.println();
					
					switch(menu) {
					case "1" :
//						System.out.println("������û ȣ��");
						courseRegistration(login.getId());
						break;
					case "2" :
//						System.out.println("������ȸ ȣ��");
						findSubject();
						break;
					case "3" :
//						System.out.println("�������� ȣ��");
						new DeleteSubject();
						break;
					case "4" :
//						System.out.println("������ȸ ȣ��");
						scoreSearch(login.getId());
						break;
					case "5" :
						System.out.println("�α׾ƿ��Ǿ����ϴ�.");
						mainMenu();
						break;
					case "6" :
						System.out.println("�ý����� ����˴ϴ�.");
						System.exit(0);
						break;
					default :
						System.out.println("�ùٸ��� ���� �޴��Դϴ�.");
						continue;
					}
				}while(menu != "6");
				
			case 2:	
				System.out.println("\n*** ������ �α����ϼ̽��ϴ�. ***");
				
				do {
					System.out.println("\n=====================================================================================================================================================");
					System.out.println("\n[MENU]	�� �������  �� �α׾ƿ�  �� ����");
					System.out.print("\n�޴��� �����Ͻÿ�: ");
					menu = scanner.next().trim();
					System.out.println();
					
					switch(menu) {
					case "1":
						registerScore(login.getId());
						break;
					case "2":
						System.out.println("�α׾ƿ��Ǿ����ϴ�.");
						mainMenu();
						break;
					case "3":
						System.out.println("�ý����� ����˴ϴ�.");
						System.exit(0);
						break;	
					default :
						System.out.println("�ùٸ��� ���� �޴��Դϴ�.");
						continue;	
					}
				} while(menu != "3");
				
				
			case 3: // ������ �޴�
				StudentDataSet.studentDataSet();
				System.out.println("\n*** �����ڷ� �α��� �ϼ̽��ϴ�. ***");
				String menu1 = "\n[menu]	�� �л����  �� �л���ȸ  �� �л�����  �� �α׾ƿ�  �� ����";
				
				int choice = 0;

				while(true) {
					System.out.println("\n=====================================================================================================================================================");
					System.out.println(menu1);
					System.out.print("\n�޴��� �����Ͻÿ�: ");
					choice = scanner.nextInt();
					System.out.println();
					
					switch(choice) {
					//�л���� ����
					case 1:
						studentRegist();
						break;


					//�л���ȸ ���� 
					case 2: 
						showStudentMember();
						while(true){
							System.out.println("\n�� Ȯ��");
							choice = scanner.nextInt();
							
							if(choice == 1) break;
							else System.out.println("�ٽ� �Է��Ͻÿ� ");
								continue;
						}
						break;
					
					//�л��������� ����	
					case 3 :
						showStudentMember();
						studentRemove(); break;
					
					//�α׾ƿ� ����
					case 4: 
						mainMenu();
						break;
						
					case 5: 
						System.out.println("�ý����� ����˴ϴ�.");
						System.exit(0);
						break;	
					
					default: 
						System.out.println("�ٽ� �Է��ϼ���");
						continue;
				}
			}
			default : 
				System.out.println("\n���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���");
				mainMenu();
		}		
	}

	
	//�л����
	public void studentRegist() {
		StudentManagement a = new StudentManagement();
		a.studentResister();
	}
	//�л����� �����
	public void studentRemove() {
		StudentManagement a = new StudentManagement();
		a.studentRemove();
	}
	//�л����
	public void showStudentMember() {
		StudentManagement a = new StudentManagement();
		a.showStudentMember();
	}
	//������û
	public void courseRegistration(int stuNum) {
		CourseRegistration cr1 = new CourseRegistration();
		cr1.courseRegistrationMain(cr1, stuNum);
	}
			
	// ������ȸ
	public void findSubject() {
		ShowSubject ss = new ShowSubject();
		ss.findSubject();
	}
	
	//������ȸ
	public void scoreSearch(int stuNum) {
		ScoreManagement rs = new ScoreManagement();
		rs.scoreSearchStuNum(stuNum);
	} 
	
	// ���� ���
	public void registerScore(int professorId) {
		ScoreManagement rs = new ScoreManagement();
		rs.insertScore(professorId);
	}
		
	public static void main(String[] args) {
		// �л���� �ý��� ����
		new AcademicSystem();
	}
	
}
