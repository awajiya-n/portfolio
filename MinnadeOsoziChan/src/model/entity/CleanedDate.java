package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class CleanedDate implements Serializable {
	private int groupId;
	private int locationId;
	private int userId;
	private String doneName;
	private Date cleanedDate;
	private int cleanedPoint;

	public CleanedDate() {}
	public CleanedDate(int groupId, int locationId, int userId, String doneName, Date cleanedDate, int cleanedPoint) {
		this.groupId = groupId;
		this.locationId = locationId;
		this.userId = userId;
		this.doneName = doneName;
		this.cleanedDate = cleanedDate;
		this.cleanedPoint = cleanedPoint;
	}

	public int getGroupId() {
		return groupId;
	}

	public int getLocationId() {
		return locationId;
	}

	public int getUserId() {
		return userId;
	}

	public String getDoneName() {
		return doneName;
	}

	public Date getCleanedDate() {
		return cleanedDate;
	}

	public int getCleanedPoint() {
		return cleanedPoint;
	}



}
