package model;

public class GameSetting {

	String firstPlayer;
	String turnPlayer;
	int cardChoiceCount;
	int playerSettingFlag;
	int gameStartFlag;
	int turnCount;

	public GameSetting(){
		this.cardChoiceCount = 1;
		this.playerSettingFlag = 1;
		this.turnCount = 1;
	}

	public String getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(String firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public String getTurnPlayer() {
		return turnPlayer;
	}

	public void setTurnPlayer(String turnPlayer) {
		this.turnPlayer = turnPlayer;
	}

	public int getCardChoiceCount() {
		return cardChoiceCount;
	}

	public void setCardChoiceCount(int cardChoiceCount) {
		this.cardChoiceCount = cardChoiceCount;
	}

	public int getPlayerSettingFlag() {
		return playerSettingFlag;
	}

	public void setPlayerSettingFlag(int playerSettingFlag) {
		this.playerSettingFlag = playerSettingFlag;
	}

	public int getGameStartFlag() {
		return gameStartFlag;
	}

	public void setGameStartFlag(int gameStartFlag) {
		this.gameStartFlag = gameStartFlag;
	}

	public int getTurnCount() {
		return turnCount;
	}

	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}

}
