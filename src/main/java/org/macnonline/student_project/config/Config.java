package org.macnonline.student_project.config;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static final Properties properties = new Properties();

    public static String getProperties(String name) {
        if (properties.isEmpty()) {
            try (FileInputStream fileInputStream = new FileInputStream("src/dao.properties")) {

                properties.load(fileInputStream);

            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException();
            }
        }
        return properties.getProperty(name);
    }


}
