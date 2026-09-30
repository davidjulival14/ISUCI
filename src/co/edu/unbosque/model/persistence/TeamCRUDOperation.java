package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.CyclistDTO;
import co.edu.unbosque.model.MassageTherapistDTO;
import co.edu.unbosque.model.SportsDirectorDTO;

public interface TeamCRUDOperation {
	public void addCyclistToTeam(int depIndex,CyclistDTO e);

	public String readAllCyclistFromTeam(int depIndex);

	public String updateCyclist(int depIndex,int indexEmp, CyclistDTO e);

	public String deleteCyclist(int depIndex,int indexEmp);
	
	public void addMassageToTeam(int depIndex,MassageTherapistDTO e);

	public String readAllMassageFromTeam(int depIndex);

	public String updateMassage(int depIndex,int indexEmp, MassageTherapistDTO e);

	public String deleteMassage(int depIndex,int indexEmp);
	
	public void addDirectorToTeam(int depIndex,SportsDirectorDTO e);

	public String readAllDirectorFromTeam(int depIndex);

	public String updateDirector(int depIndex,int indexEmp, SportsDirectorDTO e);

	public String deleteDirector(int depIndex,int indexEmp);

}
