package org.pentanet.model;

import java.util.ArrayList;

import javax.mail.internet.InternetAddress;

public class MMailData {

	private String email;
	private String tittle;
	private String body;
	private ArrayList<InternetAddress>	emailCc;

	public MMailData(String email, String tittle, String body, ArrayList<InternetAddress> emailCc) {
		// TODO Auto-generated constructor stub
		this.email= email;
		this.tittle = tittle;
		this.body = body;
		this.emailCc = emailCc;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTittle() {
		return tittle;
	}


	public void setTittle(String tittle) {
		this.tittle = tittle;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public ArrayList<InternetAddress> getEmailCc() {
		return emailCc;
	}


	public void setEmailCc(ArrayList<InternetAddress> emailCc) {
		this.emailCc = emailCc;
	}
	
	
	
}
