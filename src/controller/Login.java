package controller;

/**
 * 로그인
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
	
	// 로그인을 판별하는 메소드
	public int logCheck() {
		int logResult; 
		if(id==171111 && pw.equals("0419")) { // 학생 로그인
			logResult = 1;
		} else if(id==1111 && pw.equals("0916")) { // 교수 로그인
			logResult = 2;
		} else if(id==0000 && pw.equals("0000")) {	// 관리자 로그인
			logResult = 3;
		} else
			logResult = 4;
		return logResult;
		
	}	
}
