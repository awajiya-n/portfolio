package model;

public class RiddleLogic {
	public boolean CheckAnswer(String q1,String q2,String q3,String q4) {
		if((q1.contains("アワビ") || q1.contains("あわび") || q1.contains("鮑") || 
				q1.contains("エビ") || q1.contains("えび") || q1.contains("海老") ) && 
				q2.contains("3") && q3.contains("4") && q4.contains("6") ) {
			return true;
		} else {
			return false;
		}
	};
	
	public String AnswerQ1(String q1) {
		if(q1.contains("アワビ") || q1.contains("あわび") || q1.contains("鮑") || 
				q1.contains("エビ") || q1.contains("えび") || q1.contains("海老")) {
			return "正解";
		} else {
			return "不正解";
		}
	}
	
	public String AnswerQ2(String q2) {
		if(q2.contains("3")) {
			return "正解";
		} else {
			return "不正解";
		}
	}
	
	public String AnswerQ3(String q3) {
		if(q3.contains("4")) {
			return "正解";
		} else {
			return "不正解";
		}
	}
	
	public String AnswerQ4(String q4) {
		if(q4.contains("6")) {
			return "正解";
		} else {
			return "不正解";
		}
	}
}
