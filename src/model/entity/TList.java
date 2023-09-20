package model.entity;

import java.util.ArrayList;

public class TList {
	private ArrayList<Trophy> tList;
//
	public TList(ArrayList<Trophy> list) {
		this.tList = list;
	}

	public ArrayList<Trophy> gettList() {
		return tList;
	}

}
