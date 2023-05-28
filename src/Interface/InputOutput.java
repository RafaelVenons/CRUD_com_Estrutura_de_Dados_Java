package Interface;

import java.util.Scanner;

public class InputOutput {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static Integer menu() {
		System.out.println("===== Lista de Comprass =====");
        System.out.println("1. Inserir novo item a lista");
        System.out.println("2. Imprimir lista de Compras");
        System.out.println("3. Atualizar item da lista");
        System.out.println("4. Excluir item da lista");
        System.out.println("0. Sair");
        System.out.println("=============================");

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
	
	public static void existingItem() {
		System.out.println("Item já contem na lista!");
	}
	
	public static void voidList() {
		System.out.println("Não tem ingredientes na lista!");
	}
	
	public static void printItem(String item, Double amount) {
		System.out.println(item + " -> " + amount);
	}
	
	public static void finishUpdate(boolean success) {
		if(success)
			System.out.println("Item atualizado com sucesso!");
		else
			System.out.println("Novo item criado!");
	}
	
	public static void finishRemoveSuccess(boolean success) {
		if(success)
			System.out.println("Item removido com sucesso!");
		else
			System.out.println("Item não encontrado!");
	}
	
	public static void closingProgram() {
		System.out.println("Encerrando o programa...");
	}
	
	public static void invalidOption(){
		System.out.println("Opção inválida. Tente novamente.");
	}
}
