package model.bo;

public class SubtTPCalcLogic {

//	totalpointの演算(減算)
	public int execute(int totalPoint, int needPoint) {

		totalPoint -= needPoint;

		return totalPoint;
	}

}
