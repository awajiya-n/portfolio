package model;

public class Answer {
	private String q1;
	private String q2;
	private String q3;
	private String q4;

	private String q1Result;
	private String q2Result;
	private String q3Result;
	private String q4Result;
	private String q5Result;
	private int next;
	
	public Answer() {
		this.q1 = "";
		this.q2 = "";
		this.q3 = "";
		this.q4 = "";
		this.q1Result = "";
		this.q2Result = "";
		this.q3Result = "";
		this.q4Result = "";
		this.q5Result = "";
		this.next = 0;
	}

	public String getQ1Result() {
		return q1Result;
	}

	public void setQ1Result(String q1Result) {
		this.q1Result = q1Result;
	}

	public String getQ2Result() {
		return q2Result;
	}

	public void setQ2Result(String q2Result) {
		this.q2Result = q2Result;
	}

	public String getQ3Result() {
		return q3Result;
	}

	public void setQ3Result(String q3Result) {
		this.q3Result = q3Result;
	}

	public String getQ4Result() {
		return q4Result;
	}

	public void setQ4Result(String q4Result) {
		this.q4Result = q4Result;
	}

	public String getQ5Result() {
		return q5Result;
	}

	public void setQ5Result(String q5Result) {
		this.q5Result = q5Result;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public String getQ4() {
		return q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}
	
public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

}
