package model;

public class question {
	
	public String statement;
	public int type;
	public String option1;
	public String option2;
	public String option3;
	public String option4;
	public String nans;
	public String expected;
	
	
	//type=1 for mcq, 2 for true/false, and 3 for numeric
	
	public question() {
		
	}
	
	//Constructor for MCQ
	public question(String st,int t, String o1, String o2, String o3, String o4, String exp) {
		statement=st;
		type=t;
		option1=o1;
		option2=o2;
		option3=o3;
		option4=o4;
		expected=exp;
	}
	
	//Constructor for True/False
	public question(String st,int t,String o1,String o2,String exp) {
		statement=st;
		type=t;
		option1=o1;
		option2=o2;
		expected=exp;
	}
	
	public question(String st,int t,String ans,String exp) {
		statement=st;
		type=t;
		nans=ans;
		expected=exp;
	}
	public void setstatement(String st) {
		statement=st;
	}
	
	public void settype(int t) {
		type=t;
	}
	
	public void setoption1(String o) {
		option1=o;
	}
	
	public void setoption2(String o) {
		option2=o;
	}
	
	public void setoption3(String o) {
		option3=o;
	}
	
	public void setoption4(String o) {
		option4=o;
	}
	
	public void setnans(String ans) {
		nans=ans;
	}
	
	public void setexpected (String ex) {
		expected=ex;
	}
	
	public String getstatement() {
		return statement;
	}
	
	public int gettype() {
		return type;
	}
	
	public String getoption1() {
		return option1;
	}
	
	public String getoption2() {
		return option2;
	}
	
	public String getoption3() {
		return option3;
	}
	
	public String getoption4() {
		return option4;
	}

	public String getnans() {
		return nans;
	}
	
	public String getexpected() {
		return expected;
	}
}
