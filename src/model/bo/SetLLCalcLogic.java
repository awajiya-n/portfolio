package model.bo;

public class SetLLCalcLogic {

//	locationlevelの計算
	public int execute(int nowLLevel, int difference, int frequency) {

		int locationLevel = nowLLevel - ( difference / frequency );

		return locationLevel;
	}

}
