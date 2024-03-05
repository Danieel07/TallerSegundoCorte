package co.edu.unbosque.util.exception;

public class NoValidCharacterException extends Exception {
	public NoValidCharacterException() {
		super("Los Caracteres Especiales No son validos en este Campo");
	}
}
