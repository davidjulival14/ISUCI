package co.edu.unbosque.model;

public class User {
	private long ID;
	private String name;
	private String mail;
	private long  identificationCard;
	private String gender;
	
	public User() {
		
	}
	public User(long iD, String name, String mail, long identificationCard, String gender) {
		super();
		ID = iD;
		this.name = name;
		this.mail = mail;
		this.identificationCard = identificationCard;
		this.gender = gender;
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
	@Override
	public String toString() {
		return "ID: " + ID + "\nName: " + name + "\nMail: " + mail + "\nIdentificationCard: " + identificationCard
				+ "\n gender: " + gender + "\n";
	}
	
}
