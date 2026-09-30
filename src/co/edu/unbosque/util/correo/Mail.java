package co.edu.unbosque.util.correo;

public class Mail {

	String enviarA;
	String contenido;
	String asunto;
	String correoDe = "registro.usuarios.isuci@gmail.com";
	String contrasenia = "xpyj hfwi ewmu njmu";

	public Mail() {

	}

	public Mail(String enviarA, String contenido, String asunto, String correoDe, String contrasenia) {
		super();
		this.enviarA = enviarA;
		this.contenido = contenido;
		this.asunto = asunto;
		this.correoDe = correoDe;
		this.contrasenia = contrasenia;
	}

	public String getEnviarA() {
		return enviarA;
	}

	public void setEnviarA(String enviarA) {
		this.enviarA = enviarA;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getCorreoDe() {
		return correoDe;
	}

	public void setCorreoDe(String correoDe) {
		this.correoDe = correoDe;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}