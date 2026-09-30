package co.edu.unbosque.util.exceptions;

public class NumberOutOfRangeException extends Exception{
	public NumberOutOfRangeException() {
		super("El numero ingresado NO puede ser menor a 0, ni mayor a las opciones (4)");
	}
}
