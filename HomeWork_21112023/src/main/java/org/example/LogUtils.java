package org.example;

import java.io.*;
import java.util.Map;
import java.util.Properties;

public class LogUtils {
    public LogUtils() {
    }

    public static Properties getApplicationProperties() {
        Properties appProperties = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/resources/application.properties")) {
            appProperties.load(input);
            return appProperties;
        } catch (IOException e) {
            String message = "Properties file not found";
            Logger loggerErr1 = new Logger(message);
            loggerErr1.error(false, true, "");
        }
        return null;
    }

    public static void clearFile(String fileName){
        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.write("");
            writer.flush();
        } catch (IOException e) {
            String message = "Error writing to file";
            Logger loggerErr2 = new Logger(message);
            loggerErr2.error(false, true, "");
        }
    }

    public static void writeToFile(String fileName, String line) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(line);
            writer.flush();
        } catch (IOException e) {
            String message = "Error writing to file";
            Logger loggerErr3 = new Logger(message);
            loggerErr3.error(false, true, "");
        }
    }

    public static Map<String, String>  logEnvironmentVariables(boolean isFile, boolean isConsole, String fileName) {
        Map<String, String> vars = System.getenv();
        String title = "\nEnvironment variables";
        if (isConsole) {
            System.out.println(title);
            vars.forEach((k, v) -> System.out.println(k + " \t" + v));
        }
        if (isFile) {
            writeToFile(fileName, title+"\n");
            vars.forEach((k, v) -> writeToFile(fileName, (k + " \t" + v+"\n")));
        }
        return  vars;
    }

    public static void logProperties(Boolean isFile, Boolean isConsole, String fileName) {
        Properties vars = System.getProperties();
        String title = "\nSystem variables";
        if (isConsole) {
            System.out.println(title);
            vars.forEach((k, v) -> System.out.println(k + " \t" + v));
        }
        if (isFile) {
            writeToFile(fileName, title+"\n");
            vars.forEach((k, v) -> writeToFile(fileName, (k + " \t" + v+"\n")));
        }
    }
}