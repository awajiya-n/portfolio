package model.entity;

import java.util.ArrayList;

public class LLList {
	private ArrayList<LocationLevel> lLList;

	public LLList(ArrayList<LocationLevel> list) {
		this.lLList = list;
	}

	public ArrayList<LocationLevel> getlLList() {
		return lLList;
	}

	public void setlLList(ArrayList<LocationLevel> lLList) {
		this.lLList = lLList;
	}

}
