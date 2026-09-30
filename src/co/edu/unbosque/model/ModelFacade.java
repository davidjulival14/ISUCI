package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AdminDAO;
import co.edu.unbosque.model.persistence.CyclistDAO;
import co.edu.unbosque.model.persistence.MassageTherapistDAO;
import co.edu.unbosque.model.persistence.SportsDirectorDAO;
import co.edu.unbosque.model.persistence.TeamDAO;
import co.edu.unbosque.model.persistence.UserDAO;

public class ModelFacade {
	
	private AdminDAO adminDAO;
	private CyclistDAO ciclistaDAO;
	private MassageTherapistDAO masajistaDAO;
	private SportsDirectorDAO directorDAO;
	private TeamDAO equipoDAO;
	private UserDAO usuarioDAO;
	private UserDTO usuarioLogeado;
	
	public ModelFacade() {
		
	adminDAO = new AdminDAO();
	ciclistaDAO = new CyclistDAO();
	masajistaDAO = new MassageTherapistDAO();
	directorDAO = new SportsDirectorDAO();
	equipoDAO = new TeamDAO();
	usuarioDAO = new UserDAO();
	usuarioLogeado = new UserDTO();
	}

	public UserDTO getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(UserDTO usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public CyclistDAO getCiclistaDAO() {
		return ciclistaDAO;
	}

	public void setCiclistaDAO(CyclistDAO ciclistaDAO) {
		this.ciclistaDAO = ciclistaDAO;
	}

	public MassageTherapistDAO getMasajistaDAO() {
		return masajistaDAO;
	}

	public void setMasajistaDAO(MassageTherapistDAO masajistaDAO) {
		this.masajistaDAO = masajistaDAO;
	}

	public SportsDirectorDAO getDirectorDAO() {
		return directorDAO;
	}

	public void setDirectorDAO(SportsDirectorDAO directorDAO) {
		this.directorDAO = directorDAO;
	}

	public TeamDAO getEquipoDAO() {
		return equipoDAO;
	}

	public void setEquipoDAO(TeamDAO equipoDAO) {
		this.equipoDAO = equipoDAO;
	}

	public UserDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UserDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}
