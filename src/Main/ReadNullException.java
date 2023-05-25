package Main;

public class ReadNullException extends RuntimeException {
	ReadNullException(){
		super("Tipo de dado não encontrado");
	}
}
