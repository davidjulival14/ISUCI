package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamDTO implements Serializable {

	private String teamName;
	private String country;
	private String id_Cicla;
	private ArrayList<SportsDirectorDTO> director;
	private ArrayList<MassageTherapistDTO> assignedMasseuse;
	private ArrayList<CyclistDTO> listCyclists;

	

	public TeamDTO(String teamName, String country, String id_Cicla, ArrayList<SportsDirectorDTO> director,
			ArrayList<MassageTherapistDTO> assignedMasseuse, ArrayList<CyclistDTO> listCyclists) {
		super();
		this.teamName = teamName;
		this.country = country;
		this.id_Cicla = id_Cicla;
		this.director = director;
		this.assignedMasseuse = assignedMasseuse;
		this.listCyclists = listCyclists;
	}

	

	public String getId_Cicla() {
		return id_Cicla;
	}



	public void setId_Cicla(String id_Cicla) {
		this.id_Cicla = id_Cicla;
	}



	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ArrayList<SportsDirectorDTO> getDirector() {
		return director;
	}

	public void setDirector(ArrayList<SportsDirectorDTO> director) {
		this.director = director;
	}

	public ArrayList<MassageTherapistDTO> getAssignedMasseuse() {
		return assignedMasseuse;
	}

	public void setAssignedMasseuse(ArrayList<MassageTherapistDTO> assignedMasseuse) {
		this.assignedMasseuse = assignedMasseuse;
	}

	public ArrayList<CyclistDTO> getListCyclists() {
		return listCyclists;
	}

	public void setListCyclists(ArrayList<CyclistDTO> listCyclists) {
		this.listCyclists = listCyclists;
	}

	@Override
	public String toString() {
		return "TeamName: " + teamName + "\nCountry=" + country +  "\nis_Cicla=" + id_Cicla +"\nDirector: " + director
				+ "\nAssignedMasseuse: " + assignedMasseuse + "\nListCyclists: " + listCyclists + "\n";
	}



}
