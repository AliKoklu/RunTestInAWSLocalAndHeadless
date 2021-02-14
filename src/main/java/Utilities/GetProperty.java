package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {

    public static Properties prop;

    public static String init_properties(String expectedString){



        prop = new java.util.Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/java/config/config.properties");

            prop.load(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(expectedString);
    }
}
