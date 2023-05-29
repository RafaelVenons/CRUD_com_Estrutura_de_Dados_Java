package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import Interface.InputOutput;

public class DataDAO {
	public static Data<Double> readCSVFile(String filePath, Data<Double> list) {
		if(!fileExists(filePath)) {
			InputOutput.nonExistentPath(filePath);
			return list;
		}
		
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String item = parts[0];
                    double amount = Double.parseDouble(parts[1]);
                    list.update(item, amount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

		InputOutput.readCSVSuccess(filePath);
        return list;
    }
	
	public static void writeCSVFile(String filePath, Data<Double> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
        	if(!fileExists(filePath)) {
    			Files.createDirectories(Paths.get(filePath).getParent());
    			InputOutput.creatPath(filePath);
    		} else {
    			InputOutput.updatePath(filePath);
    		}

        	list.forEach((item, amount) -> {
                String line = item + "," + amount;
                try {
                    bw.write(line);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void deleteCSVFile(String filePath) {
        File file = new File(filePath);

        if (file.exists()) {
            if (file.delete()) {
                InputOutput.deleteFile(file.getName(), "success");
            } else {
                InputOutput.deleteFile(file.getName(), "fail");
            }
        } else {
            InputOutput.deleteFile(file.getName(), "nonExist");
        }
    }
	
	public static boolean existFiles() {
		File folder = new File("csv");
        File[] files = folder.listFiles();
        return files.length != 0;
	}
	
	private static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
