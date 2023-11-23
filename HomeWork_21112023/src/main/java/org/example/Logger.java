package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {

   private LocalDate dateMessage;
   private LocalTime timeMessage;
   private String textMessage;

    public Logger(String textMessage) {
        this.dateMessage = LocalDate.now();
        this.timeMessage = LocalTime.now();
        this.textMessage = textMessage;
    }

    public void debug(Boolean isFile, Boolean isConsole, String fileName){ //логировать всё
      outputMessage(isFile, isConsole, fileName, "DEBUG ");
    }

    public void info(Boolean isFile, Boolean isConsole, String fileName){
        outputMessage(isFile, isConsole, fileName, "INFO ");
    }

    public void warning(Boolean isFile, Boolean isConsole, String fileName){
        outputMessage(isFile, isConsole, fileName, "WARNING ");
    }

    public void error(Boolean isFile, Boolean isConsole, String fileName){
        outputMessage(isFile, isConsole, fileName, "ERROR ");
    }

    public void outputMessage(Boolean isFile, Boolean isConsole, String fileName, String type){
        String message = type + this.dateMessage.toString() + "\t"+ this.timeMessage.toString() +"\t"+
                this.textMessage + "\n";
        if (isConsole)
            System.out.println(message);
        if (isFile)
            LogUtils.writeToFile(fileName,message);
    }
}

//
// 1 уровень сложности: 1 Создайте класс Logger – класс для логирования событий в программе (дата, время и
// текст сообщения). У каждого объекта данного класса должны быть методы debug(), info(), warning(), error().
// Класс должен уметь выводить лог в консоль или в файл. В методе main() создайте объект класса Logger.
// Вызовите все доступные методы.
//2 Залогируйте все доступные параметры и переменные окружения при старте программы.
//3 Создайте файл настроек для вашей программы. В зависимости от указанных настроек программа должна включать
// заданный уровень логирования:
//debug – логировать всё
//info – логировать info, warning и error сообщения
//warning – логировать warning и error сообщения
//error  – логировать только error сообщения.
//В настройках должно быть указано, куда нужно выводить логи – в консоль или в файл.