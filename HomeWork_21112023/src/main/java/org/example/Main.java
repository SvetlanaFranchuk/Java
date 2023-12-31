package org.example;

import java.util.Map;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = new Logger("Start programs");
        Logger logger2 = new Logger("Read application.properties");

        Properties appProps = LogUtils.getApplicationProperties();
        if (appProps != null && appProps.size()!=0) {
            String level = appProps.getProperty("levelLog").toLowerCase();
            boolean isOutputConsole = Boolean.parseBoolean(appProps.getProperty("output.console"));
            boolean isOutputFile = Boolean.parseBoolean(appProps.getProperty("output.file"));
            String fileName = appProps.getProperty("fileName");
            LogUtils.clearFile(fileName);

            if ("debug".equals(level)) logger1.debug(isOutputFile, isOutputConsole, fileName);
            else {
                if ("info".equals(level)) logger1.info(isOutputFile, isOutputConsole, fileName);
            }
            if ("debug".equals(level)) logger2.debug(isOutputFile, isOutputConsole, fileName);
            else {
                if ("info".equals(level)) logger2.info(isOutputFile, isOutputConsole, fileName);
            }

            System.out.println("\nНастройки приложения из файла");
            appProps.forEach((k, v) -> System.out.printf("\t%s=%s\n", k, v));

            //2 Залогируйте все доступные параметры и переменные окружения при старте программы.
            Logger logger3 = new Logger("Read and write environment variables");
            if ("debug".equals(level)) logger3.debug(isOutputFile, isOutputConsole, fileName);
            else {
                if ("info".equals(level)) logger3.info(isOutputFile, isOutputConsole, fileName);
            }
            Map<String,String> mapJustForExample = LogUtils.logEnvironmentVariables(isOutputFile, isOutputConsole, fileName);

            Logger logger4 = new Logger("Read and write system variables");
            if ("debug".equals(level)) logger4.debug(isOutputFile, isOutputConsole, fileName);
            else {
                if ("info".equals(level)) logger4.info(isOutputFile, isOutputConsole, fileName);
            }
            LogUtils.logProperties(isOutputFile, isOutputConsole, fileName);


            if (!mapJustForExample.containsKey("Path1")){
                Logger logger5 = new Logger("Environment variables don`t contain Path1 !!!");
                if ("debug".equals(level)) logger5.debug(isOutputFile, isOutputConsole, fileName);
                else {
                    if ("info".equals(level)) logger5.info(isOutputFile, isOutputConsole, fileName);
                    if ("warning".equals(level)) logger5.warning(isOutputFile, isOutputConsole, fileName);
                }
            }

        } else
        {
            logger1.info(false, true, "");
            logger2.info(false, true, "");
            Logger loggerWarning1 = new Logger("File application.properties is empty");
            loggerWarning1.warning(false, true, "");
        }
    }
}
// 1 уровень сложности: 1 Создайте класс Logger – класс для логирования событий в программе
// (дата, время и текст сообщения). У каждого объекта данного класса должны быть методы debug(),
// info(), warning(), error(). Класс должен уметь выводить лог в консоль или в файл.
// В методе main() создайте объект класса Logger. Вызовите все доступные методы.

//3 Создайте файл настроек для вашей программы. В зависимости от указанных настроек программа
// должна включать заданный уровень логирования:
//debug – логировать всё
//info – логировать info, warning и error сообщения
//warning – логировать warning и error сообщения
//error  – логировать только error сообщения.
//В настройках должно быть указано, куда нужно выводить логи – в консоль или в файл.