package controller;

/**
 * �α���
 */
import java.util.Scanner;

public class Login {
	
	Scanner scanner = new Scanner(System.in);
	private int id;
	private String pw;
	
	public Login(int id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	// �α����� �Ǻ��ϴ� �޼ҵ�
	public int logCheck() {
		int logResult; 
		if(id==171111 && pw.equals("0419")) { // �л� �α���
			logResult = 1;
		} else if(id==1111 && pw.equals("0916")) { // ���� �α���
			logResult = 2;
		} else if(id==0000 && pw.equals("0000")) {	// ������ �α���
			logResult = 3;
		} else
			logResult = 4;
		return logResult;
		
	}	
}
