package model.entity;

import java.util.ArrayList;

public class EList {
	private ArrayList<Event> eList;

	public EList(ArrayList<Event> list) {
		this.eList = list;
	}

	public ArrayList<Event> geteList() {
		return eList;
	}

	public void seteList(ArrayList<Event> eList) {
		this.eList = eList;
	}

}
