package method;

import model.CardDate;

public class CardChoiceMethod {
	// 現在の所持数字カード数から使用するカードを減らしてインスタンスを返す
	public static CardDate numberCardReduser(CardDate cardDate,int number) {
		switch(number) {
		case 0:
			cardDate.setNo_0(cardDate.getNo_0()-1);
			break;
		case 1:
			cardDate.setNo_1(cardDate.getNo_1()-1);
			break;
		case 2:
			cardDate.setNo_2(cardDate.getNo_2()-1);
			break;
		case 3:
			cardDate.setNo_3(cardDate.getNo_3()-1);
			break;
		case 4:
			cardDate.setNo_4(cardDate.getNo_4()-1);
			break;
		case 5:
			cardDate.setNo_5(cardDate.getNo_5()-1);
			break;
		case 6:
			cardDate.setNo_6(cardDate.getNo_6()-1);
			break;
		case 7:
			cardDate.setNo_7(cardDate.getNo_7()-1);
			break;
		case 8:
			cardDate.setNo_8(cardDate.getNo_8()-1);
			break;
		case 9:
			cardDate.setNo_9(cardDate.getNo_9()-1);
			break;
		}
		return cardDate;
	}

	// 現在の所持アイテムカード数から使用するカードを減らしてインスタンスを返す
	public static CardDate itemCardReduser(CardDate cardDate,String item) {
		switch(item) {
		case "double":
			cardDate.setDouble_c(cardDate.getDouble_c()-1);
			break;
		case "highlow":
			cardDate.setHighlow_c(cardDate.getHighlow_c()-1);
			break;
		case "target":
			cardDate.setTarget_c(cardDate.getTarget_c()-1);
			break;
		case "slash":
			cardDate.setSlash_c(cardDate.getSlash_c()-1);
			break;
		case "shuffle":
			cardDate.setShuffle_c(cardDate.getShuffle_c()-1);
			break;
		case "change":
			cardDate.setChange_c(cardDate.getChange_c()-1);
			break;
		}
		return cardDate;
	}

	// 現在の所持数字カード数から獲得したカードを増やしてインスタンスを返す
	public static CardDate numberCardRaiser(CardDate cardDate,int number) {
		switch(number) {
		case 0:
			cardDate.setNo_0(cardDate.getNo_0()+1);
			break;
		case 1:
			cardDate.setNo_1(cardDate.getNo_1()+1);
			break;
		case 2:
			cardDate.setNo_2(cardDate.getNo_2()+1);
			break;
		case 3:
			cardDate.setNo_3(cardDate.getNo_3()+1);
			break;
		case 4:
			cardDate.setNo_4(cardDate.getNo_4()+1);
			break;
		case 5:
			cardDate.setNo_5(cardDate.getNo_5()+1);
			break;
		case 6:
			cardDate.setNo_6(cardDate.getNo_6()+1);
			break;
		case 7:
			cardDate.setNo_7(cardDate.getNo_7()+1);
			break;
		case 8:
			cardDate.setNo_8(cardDate.getNo_8()+1);
			break;
		case 9:
			cardDate.setNo_9(cardDate.getNo_9()+1);
			break;
		}
		return cardDate;
	}

	// 現在の所持アイテムカード数から獲得したカードを増やしてインスタンスを返す
	public static CardDate itemCardRaiser(CardDate cardDate,String item) {
		switch(item) {
		case "double":
			cardDate.setDouble_c(cardDate.getDouble_c()+1);
			break;
		case "highlow":
			cardDate.setHighlow_c(cardDate.getHighlow_c()+1);
			break;
		case "target":
			cardDate.setTarget_c(cardDate.getTarget_c()+1);
			break;
		case "slash":
			cardDate.setSlash_c(cardDate.getSlash_c()+1);
			break;
		case "shuffle":
			cardDate.setShuffle_c(cardDate.getShuffle_c()+1);
			break;
		case "change":
			cardDate.setChange_c(cardDate.getChange_c()+1);
			break;
		}
		return cardDate;
	}
}
