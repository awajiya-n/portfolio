package method;

public class NumberCheckMethod {

	// EATかどうか判定し、EATなら1、EATでなければ0を返す
	public static int eat(int choiceNumber,int guess) {
		if(choiceNumber == guess) {
			return 1;
			}
		else
			return 0;
	}

	// BITEかどうか判定し、BITEなら1、BITEでなければ0を返す
	public static int bite(int choiceNumberA,int choiceNumberB,int guess) {
		if(choiceNumberA == guess || choiceNumberB == guess) {
			return 1;
			}
		else
			return 0;
	}
}
