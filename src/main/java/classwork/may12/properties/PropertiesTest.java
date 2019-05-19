package classwork.may12.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesTest
{
    public static void main(String[] args) throws IOException
    {
        Properties properties = new Properties();
        //InputStream is = PropertiesTest.class.getClassLoader().getResourceAsStream("classwork/may12/prop.properties");
        InputStream is = PropertiesTest.class.getResourceAsStream("prop.properties");
        properties.load(is);

        System.out.println(properties.getProperty("keyA"));

        properties.setProperty("keyA","XXX");
        properties.setProperty("keyC","CCC");
        System.out.println(properties.toString());

        properties.stringPropertyNames().forEach(prop -> {
                                                            System.out.print(prop);
                                                            System.out.print("=");
                                                            System.out.println(properties.getProperty(prop));});
    }
}
