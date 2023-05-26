package Main;

public class InvalidParameterException extends RuntimeException {
	InvalidParameterException(){
		super("Entrada de parametro invalida");
	}
}
