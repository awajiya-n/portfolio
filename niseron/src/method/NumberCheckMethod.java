package method;

public class NumberCheckMethod {

	public static int eat(int choiceNumber,int guess) {
		if(choiceNumber == guess) {
			return 1;
			}
		else
			return 0;
	}

	public static int bite(int choiceNumberA,int choiceNumberB,int guess) {
		if(choiceNumberA == guess || choiceNumberB == guess) {
			return 1;
			}
		else
			return 0;
	}
}
