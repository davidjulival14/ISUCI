package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MassageTherapistDTO extends UserDTO implements Serializable{
	
	private String speciality;
	private int experienceAge;
	
	public MassageTherapistDTO() {
		// TODO Auto-generated constructor stub
	}

	public MassageTherapistDTO(String speciality, int experienceAge) {
		super();
		this.speciality = speciality;
		this.experienceAge = experienceAge;
	}

	public MassageTherapistDTO(long iD, String name, String mail, long identificationCard, String gender,
			ArrayList<String> listaMasajista, String speciality, int experienceAge) {
		super(iD, name, mail, identificationCard, gender, listaMasajista);
		this.speciality = speciality;
		this.experienceAge = experienceAge;
	}

	public MassageTherapistDTO(long iD, String name, String mail, long identificationCard, String gender,
			ArrayList<String> listaMasajista) {
		super(iD, name, mail, identificationCard, gender, listaMasajista);
		// TODO Auto-generated constructor stub
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getExperienceAge() {
		return experienceAge;
	}

	public void setExperienceAge(int experienceAge) {
		this.experienceAge = experienceAge;
	}

	@Override
	public String toString() {
		return super.toString()+ "Speciality: " + speciality + "\nExperienceAge: " + experienceAge + "\n";
	}

	
	
}
