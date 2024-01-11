package model;

public class UseCard {

	int firstNumber;
	int secondNumber;
	int thirdNumber;

	String firstItem;
	String secondItem;
	String thirdItem;

	String userName;

	public UseCard() {
		this.firstNumber = 99999;
		this.secondNumber = 99999;
		this.thirdNumber = 99999;
	}

	public int getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}
	public int getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}
	public int getThirdNumber() {
		return thirdNumber;
	}
	public void setThirdNumber(int thirdNumber) {
		this.thirdNumber = thirdNumber;
	}
	public String getFirstItem() {
		return firstItem;
	}
	public void setFirstItem(String firstItem) {
		this.firstItem = firstItem;
	}
	public String getSecondItem() {
		return secondItem;
	}
	public void setSecondItem(String secondItem) {
		this.secondItem = secondItem;
	}
	public String getThirdItem() {
		return thirdItem;
	}
	public void setThirdItem(String thirdItem) {
		this.thirdItem = thirdItem;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
