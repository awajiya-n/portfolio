package model.entity;

import java.util.ArrayList;

public class TPList {
	private ArrayList<TotalPoint> tPList;

	public TPList(ArrayList<TotalPoint> list) {
		this.tPList = list;
	}

	public ArrayList<TotalPoint> gettPList() {
		return tPList;
	}

}
