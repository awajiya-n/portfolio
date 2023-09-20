package model.entity;

import java.io.Serializable;

public class TotalPoint implements Serializable {
	private int groupId;
	private int userId;
	private int totalPoint;

	public TotalPoint() {}
	public TotalPoint(int groupId, int userId, int totalPoint) {
		this.groupId = groupId;
		this.userId = userId;
		this.totalPoint = totalPoint;
	}

	public int getGroupId() {
		return groupId;
	}

	public int getUserId() {
		return userId;
	}

	public int getTotalPoint() {
		return totalPoint;
	}



}
