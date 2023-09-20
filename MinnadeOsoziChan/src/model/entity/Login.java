package model.entity;

public class Login {
	String groupId;
	String userPass;

	public Login() {}

	public Login(String groupId,String userPass) {
		this.groupId = groupId;
		this.userPass = userPass;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

}
