package model;

public class GameConfig {
	private String gameMode;
	private String rivalMode;

	private String double_m;
	private String highlow_m;
	private String target_m;
	private String slash_m;
	private String shuffle_m;
	private String change_m;

	public GameConfig() {
		this.double_m = "off";
		this.highlow_m = "off";
		this.target_m = "off";
		this.slash_m = "off";
		this.shuffle_m = "off";
		this.change_m = "off";
	}
	public GameConfig(String double_m,String highlow_m,String target_m,String slash_m,String shuffle_m,String change_m) {
		this.double_m = double_m;
		this.highlow_m = highlow_m;
		this.target_m = target_m;
		this.slash_m = slash_m;
		this.shuffle_m = shuffle_m;
		this.change_m = change_m;
	}

	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public String getRivalMode() {
		return rivalMode;
	}
	public void setRivalMode(String rivalMode) {
		this.rivalMode = rivalMode;
	}
	public String getDouble_m() {
		return double_m;
	}
	public void setDouble_m(String double_m) {
		this.double_m = double_m;
	}
	public String getHighlow_m() {
		return highlow_m;
	}
	public void setHighlow_m(String highlow_m) {
		this.highlow_m = highlow_m;
	}
	public String getTarget_m() {
		return target_m;
	}
	public void setTarget_m(String target_m) {
		this.target_m = target_m;
	}
	public String getSlash_m() {
		return slash_m;
	}
	public void setSlash_m(String slash_m) {
		this.slash_m = slash_m;
	}
	public String getShuffle_m() {
		return shuffle_m;
	}
	public void setShuffle_m(String suffle_m) {
		this.shuffle_m = suffle_m;
	}
	public String getChange_m() {
		return change_m;
	}
	public void setChange_m(String change_m) {
		this.change_m = change_m;
	}



}
