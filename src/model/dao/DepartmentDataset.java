package model.dao;

import java.util.HashMap;

import model.vo.DepartmentVO;

public class DepartmentDataset {

	public static HashMap<Integer, DepartmentVO> departmentList = new HashMap<Integer, DepartmentVO>();
	
	public static void departmentData() {
		departmentList.put(1, new DepartmentVO(1, "��ǻ�Ͱ��а�"));
		departmentList.put(2, new DepartmentVO(2, "������а�"));
		departmentList.put(3, new DepartmentVO(3, "�ɸ��а�"));
		departmentList.put(4, new DepartmentVO(4, "�����а�"));
		departmentList.put(5, new DepartmentVO(5, "ȭ�а��а�"));
	
	}

}
