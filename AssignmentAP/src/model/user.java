package model;

import java.io.Serializable;

public class user implements Serializable {
	
	public String username;
	public String password;
	public String role;
	public int score;
	
	public user(){
	username=null;
	}
	
	public String getusername() {
		return username;
	}
	
	public String getpassword() {
		return password;
	}

	public String getrole() {
		return role;
	}
	
	public int getscore() {
		return score;
	}
	
	public void setusername(String un) {
		username=un;
	}
	
	public void setpassword(String pwd) {
		password=pwd;
	}

	public void setrole(String rl) {
		role=rl;
	}
	
	public void setscore(int scr) {
		score=scr;
	}
	
	public void printUser(){
		    System.out.printf("%s\t%s\t%s\t%d",getusername(),getpassword(),getrole(),getscore());
		    }
		    
	public user(String un, String pwd, String r, int sc){
		        setusername(un);
		        setpassword(pwd);
		        setrole(r);
		        setscore(sc);
		    }
	
	public user(String un, String pwd, String r){
        setusername(un);
        setpassword(pwd);
        setrole(r);
    }


	

}
