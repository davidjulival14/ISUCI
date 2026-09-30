package co.edu.unbosque.util.exceptions;

public class NameNotValidException extends Exception{

	public NameNotValidException() {
		super("El nombre ingresado no es válido, quitar simbolos y caracteres especiales");
	}
}
