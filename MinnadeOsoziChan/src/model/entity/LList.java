package model.entity;

import java.util.ArrayList;


public class LList {
	private ArrayList<Location> lList;

	public LList(ArrayList<Location> list) {
		this.lList = list;
	}

	public ArrayList<Location> getlList() {
		return lList;
	}

	public void setlList(ArrayList<Location> lList) {
		this.lList = lList;
	}

}
