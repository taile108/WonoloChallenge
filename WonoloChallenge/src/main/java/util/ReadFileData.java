package util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadFileData {
	
    public static Properties getTestData(String file) {
        FileInputStream fileInput = null;
        String path = "src/main/resources/data/";
        try {
            fileInput = new FileInputStream(path+file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
