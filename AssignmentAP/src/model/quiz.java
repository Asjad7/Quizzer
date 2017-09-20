package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.question;
public class quiz implements Serializable {

	public String title;
	public String description;
	List<question> questions= new ArrayList();
	
	public quiz() {
		
	}
	
	public quiz(String t,String d) {
		title=t;
		description=d;
	}
	
	public void settitle(String t) {
		title=t;
	}
	
	public void setdescription(String d) {
		description=d;
	}
	
	public void setlist(List<question> qs) {
		questions=qs;
	}
	
	public String gettitle() {
		return title;
	}
	
	public String getdescription() {
		return description;
	}
	
	public List<question> getList() {
		return questions;
	}

	
	public void addquestion(String st,int type,String o1,String o2,String o3,String o4,String expected) {
		questions.add(new question(st,type, o1, o2, o3, o4, expected));
	}
	
	public void addquestiontf(String st,int type,String o1,String o2,String expected) {
		questions.add(new question(st,type, o1, o2,expected));
	}
	
	public void addquestionnumeric(String st,int type,String ans,String expected) {
		questions.add(new question(st,type,ans,expected));
	}
	
	
	
}
