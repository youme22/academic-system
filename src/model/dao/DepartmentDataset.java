package model.dao;

import java.util.HashMap;

import model.vo.DepartmentVO;

public class DepartmentDataset {

	public static HashMap<Integer, DepartmentVO> departmentList = new HashMap<Integer, DepartmentVO>();
	
	public static void departmentData() {
		departmentList.put(1, new DepartmentVO(1, "컴퓨터공학과"));
		departmentList.put(2, new DepartmentVO(2, "산업공학과"));
		departmentList.put(3, new DepartmentVO(3, "심리학과"));
		departmentList.put(4, new DepartmentVO(4, "생명학과"));
		departmentList.put(5, new DepartmentVO(5, "화학공학과"));
	
	}

}
