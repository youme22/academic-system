package model.dao;

import java.util.HashMap;

import model.vo.StudentVO;

public class StudentDataSet {
	
	public static HashMap<Integer, StudentVO> list = new HashMap<Integer, StudentVO>();
	public StudentDataSet() {}
	public static void studentDataSet() {
		list.put(123456, new StudentVO(123456, "Á¶¼ºÇö", "Java", 9));
		list.put(223456, new StudentVO(223456, "ÀÌÁÖÈñ", "SQL",21));
		list.put(323456, new StudentVO(323456, "ÀÌ¹ÎÁö", "Java",15));
		list.put(423456, new StudentVO(423456, "ÀÌ¹ÎÇü", "SQL",9));
		list.put(523456, new StudentVO(523456, "ÀåÀåÈñ", "Java",21));
		list.put(623456, new StudentVO(623456, "Á¶¼Ò¿¬", "SQL",15));
		list.put(723456, new StudentVO(723456, "¹ÚÀÎ¼±", "Java",9));
		list.put(171111, new StudentVO(171111, "¿µÈñ", "Java",9));
	}
}
