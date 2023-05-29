package Interface;

import java.io.File;
import java.util.Scanner;

public class InputOutput {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static Integer menu() {
		System.out.println("===== Lista de Compras ========== Listas Salvas ======");
        System.out.println("1. Inserir novo item a lista|5. Mostrar listas salvas");
        System.out.println("2. Imprimir lista de Compras|6. Carregar lista");
        System.out.println("3. Atualizar item da lista  |7. Salvar lista atual");
        System.out.println("4. Excluir item da lista    |8. Excluir lista");
        System.out.println("0. Sair                     |");
        System.out.println("======================================================");

        System.out.print("Escolha uma opção: ");
        
        return scanner.nextInt();
	}
	
	public static String getItem(String option) {
		switch(option) {
			case "creat":
				System.out.print("Informe o item a ser adicionado a lista: ");
				break;
			case "update":
				System.out.print("Informe o item a ser atualizado na lista: ");
				break;
			case "remove":
				System.out.print("Informe o item a ser removido da lista: ");
				break;
			default:
				System.out.print("Informe o item");
		}
		return scanner.next(); 
	}
	
	public static Double getAmount() {
		double amount;
		System.out.print("Informe a quantidade do item: ");
		amount = scanner.nextDouble();
		while(amount <= 0.0) {
			System.out.println("Valor " + amount + " invalido!");
			System.out.print("Informe uma quantidade positiva: ");
			amount = scanner.nextDouble();
		}
		return amount;
	}
	
	public static void existingItem(String item) {
		System.out.println("Item " + item + " já contem na lista!");
	}
	
	public static void voidList() {
		System.out.println("Não tem ingredientes na lista!");
	}
	
	public static void printItem(String item, Double amount) {
		System.out.println(item + " -> " + amount);
	}
	
	public static void finishUpdateSuccess(String item, boolean success) {
		if(success)
			System.out.println("Item " + item + " atualizado com sucesso!");
		else
			System.out.println("Novo item " + item + " criado!");
	}
	
	public static void finishRemoveSuccess(String item, boolean success) {
		if(success)
			System.out.println("Item " + item + " removido com sucesso!");
		else
			System.out.println("Item " + item + " não encontrado!");
	}
	
	public static void closingProgram() {
		System.out.println("Encerrando o programa...");
	}
	
	public static void invalidOption(int option){
		System.out.println("Opção " + option + " inválida. Tente novamente.");
	}
	
	public static String getPath(String option) {
		listFiles();
		String name;
		switch(option) {
			case "create":
				System.out.print("Informe o nome da lista atual: ");
				break;
			case "read":
				System.out.print("Informe o nome da lista a ser carregada: ");
				break;
			case "delete":
				System.out.print("Informe o nome da lista a ser deletada: ");
				break;
		}
		name = scanner.next();
		return "csv\\" + name + ".cvs";
	}
	
	public static void readCSVSuccess(String path, boolean success) {
		path = pathClean(path);
		if(success) {
			System.out.println("Lista " + path + " carregado com sucesso!");
		} else {
			System.out.println("Lista " + path + " não encontrada");
		}
	}
	
	public static void creatPathSuccess(String path, boolean success) {
		path = pathClean(path);
		if(success) {
			System.out.println("Lista " + path + " criado com sucesso!");
		} else {
			System.out.println("Lista " + path + " atualizado com sucesso!");
		}
	}
	
	private static String pathClean(String path) {
		return path.substring(path.lastIndexOf('\\') + 1, path.lastIndexOf('.'));
	}
	
	public static void listFiles() {
        File folder = new File("csv");
        File[] files = folder.listFiles();
        if(files.length == 0) {
        	nonExistLists();
        	return;
        }
    	System.out.println("As Listas existentes são:");
        for(File file : files) {
        	if(file.isFile()) {
           		System.out.println(fileClean(file.getName()));
        	}
        }
	}
	
	public static void deleteFile(String file, String option) {
		file = fileClean(file);
		switch(option) {
			case "success":
				System.out.println("Arquivo " + file + " deletado com sucesso!");
				break;
			case "fail":
				System.out.println("Falha ao deletar o arquivo " + file);
				break;
			case "nonExist":
				System.out.println("O arquivo " + file + " não existe!");
				break;
		}
	}
	
	private static String fileClean(String file) {
		return file.substring(0, file.lastIndexOf('.'));
	}
	
	public static void nonExistLists() {
    	System.out.println("Não existe Listas criadas");
	}
}
