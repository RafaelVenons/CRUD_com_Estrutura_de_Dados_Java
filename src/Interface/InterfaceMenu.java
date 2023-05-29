package Interface;

import Data.Data;
import Data.DataDAO;

public class InterfaceMenu {
	
	private static Data<Double> list = new Data<Double>();
	
	public static void main(String[] args) {
        int option;

        do {
            option = InputOutput.menu();

            switch (option) {
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
                case 5:
                    showLists();
                    break;
                case 6:
                    loadList();
                    break;
                case 7:
                	saveList();
                    break;
                case 8:
                	removeList();
                    break;
                case 0:
                    InputOutput.closingProgram();
                    break;
                default:
                    InputOutput.invalidOption(option);
                    break;
            }
        } while (option != 0);
        return;
    }
	
	private static void setItem() {
		String item = InputOutput.getItem("creat");
		if(list.contains(item)){
			InputOutput.existingItem(item);
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
		InputOutput.finishUpdateSuccess(item, list.update(item, amount));
	}
	
	private static void removeItem() {
		if(printItems()) {
			String item = InputOutput.getItem("remove");
			InputOutput.finishRemoveSuccess(item, list.delete(item));
		}
	}
	
	private static void listItens() {
		list.forEach((item, amount) -> {
		      InputOutput.printItem(item, amount);
		});
	}
	
	private static void showLists() {
		InputOutput.listFiles();
	}
	
	private static void loadList() {
		if(DataDAO.existFiles()) {
			DataDAO.readCSVFile(InputOutput.getPath("read"), list);
		} else {
			InputOutput.nonExistLists();
		}
	}
	
	private static void saveList() {
		if(list.size() != 0) {
			DataDAO.writeCSVFile(InputOutput.getPath("create"), list);
		} else {
			InputOutput.voidList();
		}
	}
	
	private static void removeList() {
		if(DataDAO.existFiles()) {
			DataDAO.deleteCSVFile(InputOutput.getPath("delete"));
		} else {
			InputOutput.nonExistLists();
		}
	}
}
