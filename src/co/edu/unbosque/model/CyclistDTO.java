package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CyclistDTO extends UserDTO implements Serializable {
	private int raceTime;
	private String speciality;
	private int pedalingCadence;
	private float weight;
	private float height;
	
	public CyclistDTO() {
		// TODO Auto-generated constructor stub
	}

	public CyclistDTO(long iD, String name, String mail, long identificationCard, String gender,
			ArrayList<String> listaCyclista) {
		super(iD, name, mail, identificationCard, gender, listaCyclista);
		// TODO Auto-generated constructor stub
	}

	public CyclistDTO(int raceTime, String speciality, int pedalingCadence, float weight,
			float height) {
		super();
		this.raceTime = raceTime;
		this.speciality = speciality;
		this.pedalingCadence = pedalingCadence;
		this.weight = weight;
		this.height = height;
	}

	public CyclistDTO(long iD, String name, String mail, long identificationCard, String gender,
			ArrayList<String> listaUsuarios, int raceTime, String speciality, int pedalingCadence,
			float weight, float height) {
		super(iD, name, mail, identificationCard, gender, listaUsuarios);
		this.raceTime = raceTime;
		this.speciality = speciality;
		this.pedalingCadence = pedalingCadence;
		this.weight = weight;
		this.height = height;
	}

	@Override
	public String toString() {
		
		return super.toString()+ "RaceTime: " + raceTime + "\nSpeciality: " + speciality + "\nPedalingCadence: "
				+ pedalingCadence + "\nWeight: " + weight + "\nHeight: " + height + "\n";
	}
	
	
	public int getRaceTime() {
		return raceTime;
	}

	public void setRaceTime(int raceTime) {
		this.raceTime = raceTime;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getPedalingCadence() {
		return pedalingCadence;
	}

	public void setPedalingCadence(int pedalingCadence) {
		this.pedalingCadence = pedalingCadence;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}
