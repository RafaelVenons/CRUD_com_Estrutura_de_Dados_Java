package Interface;

import Data.Data;

public class InterfaceMenu {
	
	private static Data<Double> list = new Data<Double>();
	
	public static void main(String[] args) {
        int opcao;

        do {
            opcao = InputOutput.menu();

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
                    InputOutput.closingProgram();
                    break;
                default:
                    InputOutput.invalidOption();
                    break;
            }
        } while (opcao != 0);
        return;
    }
	
	private static void setItem() {
		String item = InputOutput.getItem("creat");
		if(list.contains(item)){
			InputOutput.existingItem();
			return;
		} 
		Double amount = InputOutput.getAmount();
		list.create(item, amount);
	}
	
	private static boolean printItems() {
		if(list.size() == 0){
			InputOutput.voidList();
			return false;
		}
		listItens();
		return true;
	}
	
	private static void updateItem() {
		String item = InputOutput.getItem(printItems() ? "update" : "creat");
		Double amount = InputOutput.getAmount();
		InputOutput.finishUpdate(list.update(item, amount));
	}
	
	private static void removeItem() {
		if(printItems()) {
			String item = InputOutput.getItem("remove");
			InputOutput.finishRemoveSuccess(list.delete(item));
		}
	}
	
	private static void listItens() {
		list.forEach((item, amount) -> {
		      InputOutput.printItem(item, amount);
		});
	}
}
