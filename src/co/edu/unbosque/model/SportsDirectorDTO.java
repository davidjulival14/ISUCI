package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class SportsDirectorDTO extends UserDTO implements Serializable{
	
	private String nationality;
	private String equipmentHistory;
	private int experienceAge;
	
	public SportsDirectorDTO() {
		// TODO Auto-generated constructor stub
	}

	public SportsDirectorDTO(long iD, String name, String mail, long identificationCard, String gender,
			ArrayList<String> listaDirector) {
		super(iD, name, mail, identificationCard, gender, listaDirector);
		// TODO Auto-generated constructor stub
	}

	public SportsDirectorDTO(String nationality, String equipmentHistory, int experienceAge) {
		super();
		this.nationality = nationality;
		this.equipmentHistory = equipmentHistory;
		this.experienceAge = experienceAge;
	}

	public SportsDirectorDTO(long iD, String name, String mail, long identificationCard, String gender,
			ArrayList<String> listaDirector, String nationality, String equipmentHistory, int experienceAge) {
		super(iD, name, mail, identificationCard, gender, listaDirector);
		this.nationality = nationality;
		this.equipmentHistory = equipmentHistory;
		this.experienceAge = experienceAge;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEquipmentHistory() {
		return equipmentHistory;
	}

	public void setEquipmentHistory(String equipmentHistory) {
		this.equipmentHistory = equipmentHistory;
	}

	public int getExperienceAge() {
		return experienceAge;
	}

	public void setExperienceAge(int experienceAge) {
		this.experienceAge = experienceAge;
	}

	@Override
	public String toString() {
		return super.toString()+ "Nationality: " + nationality + "\nEquipmentHistory: " + equipmentHistory
				+ "\nExperienceAge: " + experienceAge + "\n";
	}

}