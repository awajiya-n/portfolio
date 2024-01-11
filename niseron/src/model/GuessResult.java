package model;

import java.util.ArrayList;

public class GuessResult {

	int eat;
	int bite;
	ArrayList<ArrayList<Integer>> result;
	ArrayList<ArrayList<Integer>> guessNumber;

	public GuessResult(){
		this.result = new ArrayList<ArrayList<Integer>>();
		this.guessNumber = new ArrayList<ArrayList<Integer>>();
	}

	public int getEat() {
		return eat;
	}
	public void setEat(int eat) {
		this.eat = eat;
	}
	public int getBite() {
		return bite;
	}
	public void setBite(int bite) {
		this.bite = bite;
	}
	public ArrayList<ArrayList<Integer>> getResult() {
		return result;
	}
	public void setResult(ArrayList<ArrayList<Integer>> result) {
		this.result = result;
	}
	public ArrayList<ArrayList<Integer>> getGuessNumber() {
		return guessNumber;
	}
	public void setGuessNumber(ArrayList<ArrayList<Integer>> guessNumber) {
		this.guessNumber = guessNumber;
	}


}
