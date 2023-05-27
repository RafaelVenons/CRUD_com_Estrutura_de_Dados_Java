package Interface;

import java.util.Scanner;

import Data.Data;

public class InterfaceMenu {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Data<Double> list = new Data<Double>();
	
	public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("===== Lista de Comprass =====");
            System.out.println("1. Inserir novo item a lista");
            System.out.println("2. Imprimir lista de Compras");
            System.out.println("3. Atualizar item da lista");
            System.out.println("4. Excluir item da lista");
            System.out.println("0. Sair");
            System.out.println("=============================");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    setItem();
                    break;
                case 2:
                    printItems();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
	
	private static void setItem() {
		System.out.print("Informe o item a ser adicionado a lista: ");
		String item = scanner.next();
		if(list.contains(item)){
			System.out.println("Item já contem na lista!");
			return;
		} 
		System.out.print("Informe a quantidade do item: ");
		Double amount = scanner.nextDouble();
		list.create(item, amount);
	}
	
	private static void printItems() {
		if(list.size() == 0){
			System.out.println("Não tem ingredientes na lista!");
			return;
		}
		list.forEach((item, amount) -> {
		      System.out.println(item + " -> " + amount);
		});
	}
	
	private static void updateItem() {
		System.out.print("Informe o item a ser adicionado a lista: ");
		String item = scanner.next();
		System.out.print("Informe a quantidade do item: ");
		Double amount = scanner.nextDouble();
		if(list.update(item, amount)) {
			System.out.println("Item atualizado com sucesso!");
		}else {
			System.out.println("Item não encontrado, criado novo tem!");
		}
	}
	
	private static void removeItem() {
		System.out.print("Informe o item a ser adicionado a lista: ");
		String item = scanner.next();
		if(list.delete(item)) {
			System.out.println("Item removido com sucesso!");
			return;
		}
		System.out.println("Item não encontrado!");
	}
}
