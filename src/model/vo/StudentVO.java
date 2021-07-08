package model.vo;

public class StudentVO {
	private int stuNum;
	private String stuName;
	private String stuMajor;
	private int stuMaxCredit;
	
	
	public StudentVO() {
	}
	public StudentVO(int stuNum,String stuName, String stuMajor, int stuMaxCredit) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuMajor = stuMajor;
		this.stuMaxCredit = stuMaxCredit;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public int getStuMaxCredit() {
		return stuMaxCredit;
	}
	public void setStuMaxCredit(int stuMaxCredit) {
		this.stuMaxCredit = stuMaxCredit;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuMajor() {
		return stuMajor;
	}
	public void setStuMajor(String stuMajor) {
		this.stuMajor = stuMajor;
	}
	
}
