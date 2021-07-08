package model.dao;

import java.util.HashMap;

import model.vo.OpeningSubjectVO;

public class OpeningSubjectDataset {

	public static HashMap<Integer, OpeningSubjectVO> oSubjectList = new  HashMap<Integer, OpeningSubjectVO>();
	public static int insertNum = 1;
	
	public static void openingSubjectData() {
		if (insertNum == 1) {
			oSubjectList.put(10, new OpeningSubjectVO(10, "소프트웨어공학론", "전필", "목 1,2,3", 1, 3, 3, 1000, 30, 30));
			oSubjectList.put(11, new OpeningSubjectVO(11, "산업공학론", "전필", "금 1,2,3", 2, 2, 3, 2000, 30, 25));
			oSubjectList.put(12, new OpeningSubjectVO(12, "화학실험", "교필", "월 1,2,3", 5, 4, 3, 5000, 20, 0));
			oSubjectList.put(13, new OpeningSubjectVO(13, "세포생물학", "전필", "화 1,2,3", 4, 2, 3, 4000, 25, 3));
			oSubjectList.put(14, new OpeningSubjectVO(14, "심리학개론", "교필", "수 1,2,3", 3, 1, 3, 3000, 50, 0));
		}
	}
}
