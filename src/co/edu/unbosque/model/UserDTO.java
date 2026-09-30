package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;


public class UserDTO implements Serializable{
	private long ID;
	private String name;
	private String mail;
	private long  identificationCard;
	private String gender;
	private ArrayList<String> lista;
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(long iD, String name, String mail, long identificationCard, String gender, ArrayList<String> lista) {
		super();
		ID = iD;
		this.name = name;
		this.mail = mail;
		this.identificationCard = identificationCard;
		this.gender = gender;
		this.lista = lista;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
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

	public long getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(long identificationCard) {
		this.identificationCard = identificationCard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<String> getLista() {
		return lista;
	}

	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "ID: " + ID + "\nName: " + name + "\nMail: " + mail + "\nIdentificationCard: " + identificationCard
				+ "\nGender: " + gender + "\n";
	}


	

	

	
}
