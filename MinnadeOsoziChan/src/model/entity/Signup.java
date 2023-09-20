package model.entity;
//管理者登録のentity
public class Signup {
	int groupId;
	String groupName;
	String userName;
	String userPass;
	int adminFlg;

	public Signup() {}

	public Signup(int groupId,String groupName, String userName, String userPass, int adminFlg) {
		this.groupId=groupId;
		this.groupName=groupName;
		this.userName=userName;
		this.userPass=userPass;
		this.adminFlg=adminFlg;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId=groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName=groupName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName=userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass=userPass;
	}

	public int getAdminFlg() {
		return adminFlg;
	}

	public void setAdminFlg(int adminFlg) {
		this.adminFlg=adminFlg;
	}
}
