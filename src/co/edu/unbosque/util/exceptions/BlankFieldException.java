/*
	*@autor Valderrama.J - Gonzales.Y 
	*@version 2.0 
	*
	*The BlankFieldException class represents an exception that verify blank fields.
 */
package co.edu.unbosque.util.exceptions;

public class BlankFieldException extends Exception {

	public BlankFieldException() {
		super("No pueden haber campos vacios");
	}

}
