package model.entity;

import java.io.Serializable;

public class Trophy implements Serializable {
	private int groupId;
	private int trophyId;
	private String trophyName;
	private int trophyPoint;

	public Trophy() {}
	public Trophy(int groupId, int trophyId, String trophyName, int trophyPoint) {
		this.groupId = groupId;
		this.trophyId = trophyId;
		this.trophyName = trophyName;
		this.trophyPoint = trophyPoint;
	}

	public int getGroupId() {
		return groupId;
	}

	public int getTrophyId() {
		return trophyId;
	}

	public String getTrophyName() {
		return trophyName;
	}

	public int getTrophyPoint() {
		return trophyPoint;
	}



}
