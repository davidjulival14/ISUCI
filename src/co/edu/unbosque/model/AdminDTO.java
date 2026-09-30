package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class AdminDTO implements Serializable {

	private String name;
	private String mail;
	private long iD;

	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdminDTO(String name, String mail, long iD) {
		super();
		this.name = name;
		this.mail = mail;
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nMail: " + mail + "\nID: " + iD + "\n";
	}

}
