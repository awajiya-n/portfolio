package model;

public class CardDate {

	private int no_0;
	private int no_1;
	private int no_2;
	private int no_3;
	private int no_4;
	private int no_5;
	private int no_6;
	private int no_7;
	private int no_8;
	private int no_9;

	private int double_c;
	private int highlow_c;
	private int target_c;
	private int slash_c;
	private int shuffle_c;
	private int change_c;

	public CardDate(){
		this.no_0 = 1;
		this.no_1 = 1;
		this.no_2 = 1;
		this.no_3 = 1;
		this.no_3 = 1;
		this.no_4 = 1;
		this.no_5 = 1;
		this.no_6 = 1;
		this.no_7 = 1;
		this.no_8 = 1;
		this.no_9 = 1;

		this.double_c = 0;
		this.highlow_c = 0;
		this.target_c = 0;
		this.slash_c = 0;
		this.shuffle_c = 0;
		this.change_c = 0;
	}
	public CardDate(
			int no_0,int no_1,int no_2,int no_3,int no_4,
			int no_5,int no_6,int no_7,int no_8,int no_9,
			int double_c,int highlow_c,int target_c,
			int slash_c,int shuffle_c,int change_c)
	{
		this.no_0 = no_0;
		this.no_1 = no_1;
		this.no_2 = no_2;
		this.no_3 = no_3;
		this.no_4 = no_4;
		this.no_5 = no_5;
		this.no_6 = no_6;
		this.no_7 = no_7;
		this.no_8 = no_8;
		this.no_9 = no_9;

		this.double_c = double_c;
		this.highlow_c = highlow_c;
		this.target_c = target_c;
		this.slash_c = slash_c;
		this.shuffle_c = shuffle_c;
		this.change_c = change_c;
	}
	public int getNo_0() {
		return no_0;
	}
	public void setNo_0(int no_0) {
		this.no_0 = no_0;
	}
	public int getNo_1() {
		return no_1;
	}
	public void setNo_1(int no_1) {
		this.no_1 = no_1;
	}
	public int getNo_2() {
		return no_2;
	}
	public void setNo_2(int no_2) {
		this.no_2 = no_2;
	}
	public int getNo_3() {
		return no_3;
	}
	public void setNo_3(int no_3) {
		this.no_3 = no_3;
	}
	public int getNo_4() {
		return no_4;
	}
	public void setNo_4(int no_4) {
		this.no_4 = no_4;
	}
	public int getNo_5() {
		return no_5;
	}
	public void setNo_5(int no_5) {
		this.no_5 = no_5;
	}
	public int getNo_6() {
		return no_6;
	}
	public void setNo_6(int no_6) {
		this.no_6 = no_6;
	}
	public int getNo_7() {
		return no_7;
	}
	public void setNo_7(int no_7) {
		this.no_7 = no_7;
	}
	public int getNo_8() {
		return no_8;
	}
	public void setNo_8(int no_8) {
		this.no_8 = no_8;
	}
	public int getNo_9() {
		return no_9;
	}
	public void setNo_9(int no_9) {
		this.no_9 = no_9;
	}
	public int getDouble_c() {
		return double_c;
	}
	public void setDouble_c(int double_c) {
		this.double_c = double_c;
	}
	public int getHighlow_c() {
		return highlow_c;
	}
	public void setHighlow_c(int highlow_c) {
		this.highlow_c = highlow_c;
	}
	public int getTarget_c() {
		return target_c;
	}
	public void setTarget_c(int target_c) {
		this.target_c = target_c;
	}
	public int getSlash_c() {
		return slash_c;
	}
	public void setSlash_c(int slash_c) {
		this.slash_c = slash_c;
	}
	public int getShuffle_c() {
		return shuffle_c;
	}
	public void setShuffle_c(int suffle_c) {
		this.shuffle_c = suffle_c;
	}
	public int getChange_c() {
		return change_c;
	}
	public void setChange_c(int change_c) {
		this.change_c = change_c;
	}

}
