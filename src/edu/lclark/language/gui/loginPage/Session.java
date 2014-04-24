package edu.lclark.language.gui.loginPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {

	private String user;
	private Date date;

	public Session(String user){
		date = new Date();
		this.user = user;
	}
	
	public String getUser(){
		return user;
	}
	
	public String getDate(){
		return new SimpleDateFormat("MM_dd_yyyy").format(date);
	}
}
