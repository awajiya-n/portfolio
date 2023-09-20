package model.entity;

import java.io.Serializable;
import java.sql.Date;


public class LocationInfo implements Serializable {

	private int groupId;
	private int locationId;
	private String roomPngPath;
	private int charaId;
	private int charaDetailId;
	private String charaPngPath;
	private Date lateCleanedDate;
	private String doneName;

	public LocationInfo() {}
	public LocationInfo(int groupId, int locationId, String roomPngPath, int charaId, int charaDetailId, String charaPngPath, Date lateCleanedDate, String doneName) {
		this.groupId = groupId;
		this.locationId = locationId;
		this.roomPngPath = roomPngPath;
		this.charaId = charaId;
		this.charaDetailId = charaDetailId;
		this.charaPngPath = charaPngPath;
		this.lateCleanedDate = lateCleanedDate;
		this.doneName = doneName;
	}


	public int getGroupId() {
		return groupId;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public String getRoomPngPath() {
		return roomPngPath;
	}


	public void setRoomPngPath(String roomPngPath) {
		this.roomPngPath = roomPngPath;
	}


	public int getCharaId() {
		return charaId;
	}


	public void setCharaId(int charaId) {
		this.charaId = charaId;
	}


	public int getCharaDetailId() {
		return charaDetailId;
	}


	public void setCharaDetailId(int charaDetailId) {
		this.charaDetailId = charaDetailId;
	}


	public String getCharaPngPath() {
		return charaPngPath;
	}


	public void setCharaPngPath(String charaPngPath) {
		this.charaPngPath = charaPngPath;
	}


	public Date getLateCleanedDate() {
		return lateCleanedDate;
	}


	public void setLateCleanedDate(Date lateCleanedDate) {
		this.lateCleanedDate = lateCleanedDate;
	}


	public String getDoneName() {
		return doneName;
	}


	public void setDoneName(String doneName) {
		this.doneName = doneName;
	}

}
