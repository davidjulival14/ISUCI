package co.edu.unbosque.view;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Consola {
	private Scanner sc;

	public Consola() {
		sc = new Scanner(System.in);
	}

	public void burnLine() {
		sc.nextLine();
	}

	public String readLine() {
		return sc.nextLine();
	}

	public String readWord() {
		return sc.next();
	}

	public int readInt() {
		return sc.nextInt();
	}

	public long readLong() {
		return sc.nextLong();
	}

	public float readFloat() {
		return sc.nextFloat();
	}

	public double readDouble() {
		return sc.nextDouble();
	}

	public char readChar() {
		return sc.nextLine().charAt(0);
	}

	public boolean readBoolean() {

		String input = sc.nextLine();
		if (input.toLowerCase().contains("si")) {
			return true;
		}
		return false;
	}

	public BigInteger readBigInt() {
		return sc.nextBigInteger();
	}

	public BigDecimal readBigDecimal() {
		return sc.nextBigDecimal();
	}

	////////////////////////////////////////////////////

	public void printNewLine(String text) {
		System.out.println(text);
	}
	public void printSameLine(String text) {
		System.out.print(text);
	}
	public String readString(String mensaje) {
		System.out.println(mensaje);
		String aux = sc.next();
		return aux;
	}
	/*
	 * ========== DATOS EN VENTANAS EMERGENTES =================
	 */
	
	public void imprimirTextoVE(String cadena) {
		JOptionPane.showMessageDialog(null, cadena);
	}
	
	public int confirmarTextoVE(String cadena) {
		return JOptionPane.showConfirmDialog(null, cadena, "CONFIRMACION", JOptionPane.YES_NO_OPTION);
	}
}
