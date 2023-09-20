package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class LocationLevel implements Serializable {
	private int groupId;
	private int locationId;
	private int nowLLevel;
	private Date lateCleanedDate;

	public LocationLevel() {}
	public LocationLevel(int groupId, int locationId, int nowLLevel, Date lateCleanedDate) {
		this.groupId = groupId;
		this.locationId = locationId;
		this.nowLLevel = nowLLevel;
		this.lateCleanedDate = lateCleanedDate;
	}

	public int getGroupId() {
		return groupId;
	}

	public int getLocationId() {
		return locationId;
	}

	public int getNowLLevel() {
		return nowLLevel;
	}

	public Date getLateCleanedDate() {
		return lateCleanedDate;
	}



}
