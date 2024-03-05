package co.edu.unbosque.view;

import java.util.Scanner;

public class Console {
private Scanner lector;
	
	public Console() {
		lector = new Scanner(System.in);
	}

	public int leer_Entero() {
		
		return lector.nextInt();

	}

	public float leer_decimal() {

		return lector.nextFloat();

	}

	public double leer_double() {

		return lector.nextDouble();

	}

	public long leer_long() {

		return lector.nextLong();

	}

	public String leer_linea() {

		return lector.nextLine();

	}

	public String leer_palabra() {

		return lector.next();

	}

	public char leer_letra() {

		return lector.next().charAt(0);

	}

	public void imprimirTexto(Object object) {
		System.out.println(object);
	}

}
