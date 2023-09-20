package model.entity;

public class Account {
	private int groupId;
	private String groupName;
	private int userId;
	private String userName;
	private String userPass;
	private int adminFlg;
	private int loginFlg;
	private int checkResult;

	public Account() {}

	public Account(int groupId, String groupName, int userId, String userName, String userPass, int adminFlg) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.userId = userId;
		this.userName = userName;
		this.adminFlg = adminFlg;
	}

	public Account(String groupName, String userName, String userPass,int userId, int adminFlg) {
		this.groupName = groupName;
		this.userName = userName;
		this.userPass = userPass;
		this.userId = userId;
		this.adminFlg = adminFlg;
	}


	public Account(String groupName, int userId, String userName, String userPass, int adminFlg) {
		this.groupName = groupName;
		this.userId = userId;
		this.userName = userName;
		this.adminFlg = adminFlg;
	}

	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getAdminFlg() {
		return adminFlg;
	}
	public void setAdminFlg(int adminFlg) {
		this.adminFlg = adminFlg;
	}
	public int getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(int loginFlg) {
		this.loginFlg = loginFlg;
	}
	public int getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(int checkResult) {
		this.checkResult = checkResult;
	}


}
