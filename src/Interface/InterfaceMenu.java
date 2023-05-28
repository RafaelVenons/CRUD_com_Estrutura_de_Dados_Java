package Interface;

import Data.Data;

public class InterfaceMenu {
	
	private static Data<Double> list = new Data<Double>();
	private static InputOutput io = new InputOutput();
	
	public static void main(String[] args) {
        int opcao;

        do {
            opcao = io.menu();

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
                    io.closingProgram();
                    break;
                default:
                    io.invalidOption();
                    break;
            }
        } while (opcao != 0);
        return;
    }
	
	private static void setItem() {
		String item = io.getItem("creat");
		if(list.contains(item)){
			io.existingItem();
			return;
		} 
		Double amount = io.getAmount();
		list.create(item, amount);
	}
	
	private static boolean printItems() {
		if(list.size() == 0){
			io.voidList();
			return false;
		}
		listItens();
		return true;
	}
	
	private static void updateItem() {
		String item = io.getItem(printItems() ? "update" : "creat");
		Double amount = io.getAmount();
		io.finishUpdate(list.update(item, amount));
	}
	
	private static void removeItem() {
		if(printItems()) {
			String item = io.getItem("remove");
			io.finishRemoveSuccess(list.delete(item));
		}
	}
	
	private static void listItens() {
		list.forEach((item, amount) -> {
		      io.printItem(item, amount);
		});
	}
}
