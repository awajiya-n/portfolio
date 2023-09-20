package model.bo;

public class AddTPCalcLogic {

//	totalpointの演算(加算)
	public int execute(int totalPoint, int point) {

		totalPoint += point;

		return totalPoint;
	}

}
