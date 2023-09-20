package model.entity;

import java.util.ArrayList;

public class CDList {
	private ArrayList<CleanedDate> cdList;

	public CDList(ArrayList<CleanedDate> list) {
		this.cdList = list;
	}

	public ArrayList<CleanedDate> getCdList() {
		return cdList;
	}

}
