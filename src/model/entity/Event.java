package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class Event implements Serializable {
	private int groupId;
	private Date startDate;
	private Date endDate;
	private String text;

	public Event() {}
	public Event(int groupId, Date startDate, Date endDate, String text) {
		this.groupId = groupId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.text = text;
	}

	public int getGroupId() {
		return groupId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getText() {
		return text;
	}


}
