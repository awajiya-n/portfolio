package model;

public class User {
	private int userId;
	private String name;
	private String pass;

	private String userType;

	private int winPoint;
	private int losePoint;

	public User() {};

	public User(String name,String userType){
		this.name = name;
		this.userType = userType;
	}
	public User(String name,String pass,String userType){
		this.name = name;
		this.pass = pass;
		this.userType = userType;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getWinPoint() {
		return winPoint;
	}
	public void setWinPoint(int winPoint) {
		this.winPoint = winPoint;
	}
	public int getLosePoint() {
		return losePoint;
	}
	public void setLosePoint(int losePoint) {
		this.losePoint = losePoint;
	}



}
