package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    public static Properties properties;

    static {//Her method dan önce calisir

        String filePath = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);//fis in okuduu bilgileri properties `e yükledi

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static String getProperty(String key) {
        /*
        Test meth gelen string key degerini alip Properties class ' indan getProperty()
         kullanarak bu key ' e ait vaalue yi bize getirir
         */

        return properties.getProperty(key);
    }

}
