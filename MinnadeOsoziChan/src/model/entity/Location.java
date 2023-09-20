package model.entity;

import java.io.Serializable;

public class Location implements Serializable {
	private int groupId;
	private int locationId;
	private String locationName;
	private int frequency;
	private int charaId;
	private int roomPhotoId;
	private int setPoint;

	public Location() {}
	public Location(int groupId, int locationId, String locationName, int frequency, int charaId, int roomPhotoId, int setPoint) {
		this.groupId = groupId;
		this.locationId = locationId;
		this.locationName = locationName;
		this.frequency = frequency;
		this.charaId = charaId;
		this.roomPhotoId = roomPhotoId;
		this.setPoint = setPoint;

	}


	public int getGroupId() {
		return groupId;
	}


	public int getLocationId() {
		return locationId;
	}


	public String getLocationName() {
		return locationName;
	}


	public int getFrequency() {
		return frequency;
	}


	public int getCharaId() {
		return charaId;
	}


	public int getRoomPhotoId() {
		return roomPhotoId;
	}


	public int getSetPoint() {
		return setPoint;
	}




}
