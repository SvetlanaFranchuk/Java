package org.example.task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainTask1 {
    public static void main(String[] args) {
        Product product1 = new Product("apple", 1.45, 10, "Good apple");

        Class<Product> clazz = Product.class;

        String className = clazz.getName();
        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();

        System.out.println("className: " +className);
        System.out.println("getSimpleName: " + clazz.getSimpleName());
        printFields(fields);
        System.out.println();
        printMethods(methods);

        Map<String, Boolean> NameIsMethod = new HashMap<>();
        for (Method method : methods) {
            NameIsMethod.put(method.getName(), true);
        }
        for (Field field : fields) {
            NameIsMethod.put(field.getName(), false);
        }

        System.out.println("____________________");
        System.out.println();
        String name;
        AtomicBoolean isNameFound = new AtomicBoolean(false);
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name Field or method (or enter STOP): ");
            name = scanner.nextLine();
            for (Map.Entry<String, Boolean> entry : NameIsMethod.entrySet()) {
                String k = entry.getKey();
                Boolean v = entry.getValue();
                if (k.equals(name) && !v) {
                    changeValueField(name, fields, product1);
                    isNameFound.set(true);
                    break;
                } else if (k.equals(name) && v) {
                    executeMethod(name, methods, product1);
                    isNameFound.set(true);
                    break;
                } else isNameFound.set(false);
            }
            if (!isNameFound.get() && !name.equals("STOP"))
                System.out.println("This name field or method not found");
        } while (!name.equals("STOP")) ;
    }

    public static void executeMethod(String name, Method[] methods, Product product1){
        for (int i = 0; i < methods.length ; i++) {
            if (methods[i].getName().equals(name)){
                List<String> inputTypes = Arrays.stream(methods[i].getParameterTypes()).map(Class::getSimpleName).toList();
                if (inputTypes.size()==0) {
                    try {
                        methods[i].setAccessible(true);
                        if (!methods[i].getReturnType().toString().equals("void"))
                            System.out.println(methods[i].invoke(product1));
                        else
                            methods[i].invoke(product1);
                        methods[i].setAccessible(false);
                    } catch (IllegalAccessException|InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                    return;
                } else {
                    for (int j = 0; j < inputTypes.size(); j++) {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.print("Enter value of parameter - type (" + inputTypes.get(j) + "): ");
                        String value = scanner1.nextLine();
                        methods[i].setAccessible(true);
                        try {
                            if (inputTypes.get(j).equals(int.class.getSimpleName()))
                                if (!methods[i].getReturnType().toString().equals("void"))
                                     System.out.println(methods[i].invoke(product1, Integer.parseInt(value)));
                                else methods[i].invoke(product1, Integer.parseInt(value));
                            else
                                if (!methods[i].getReturnType().toString().equals("void"))
                                     System.out.println(methods[i].invoke(product1, Double.parseDouble(value)));
                                else methods[i].invoke(product1, Integer.parseInt(value));
                            //????????? Юрий, тут вопрос - почему не получается через тернарный оператор передать в invoke
                        } catch (IllegalAccessException| InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        methods[i].setAccessible(false);
                    }
                }
            }
        }
    }

    public static void changeValueField(String name, Field[] fields, Product product){
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter new value of this field: ");
        String value = scanner1.nextLine();
        for (Field field : fields) {
            if (field.getName().equals(name)) {
                field.setAccessible(true);
                try {
                    field.set(product, field.getType().equals(String.class) ? value :
                            field.getType().equals(int.class) ? Integer.parseInt(value) : Double.parseDouble(value));
                    System.out.println("New value set. Field: " + name + " = " + value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                field.setAccessible(false);
                return;
            }
        }
    }

    public static void printMethods(Method[] methods ){
        for (Method method : methods) {
            String name = method.getName();
            String returnType = method.getReturnType().getSimpleName();
            List<String> inputTypes = Arrays.stream(method.getParameterTypes()).map(Class::getSimpleName).toList();
            List<String> exceptionTypes = Arrays.stream(method.getExceptionTypes()).map(Class::getSimpleName).toList();
            System.out.printf("Method: %s, return type: %s, params: %s, exceptions: %s%n", name, returnType, inputTypes, exceptionTypes);
        }
    }

    public static void printFields(Field[] fields) {
        Map<String, String> fieldsInfo = new HashMap<>();
        for (Field value : fields) {
            fieldsInfo.put(value.getName(), value.getType().getSimpleName());
        }
       fieldsInfo.forEach((k,v)-> System.out.println("Field: " + k + ":" + v ));
    }
}
//Создайте класс с 10 методами и 4 приватными полями. Геттеры и сеттеры добавлять не нужно. Создайте объект Вашего
//класса. Выведите в консоль информацию об объекте. Затем пользователь вводит имя поля или метода. Программа определяет,
//имя какого члена класса было введено. Если введено имя метода, то этот метод немедленно вызывается. Если введено имя
//поля, то программа запрашивает у пользователя новое значение и устанавливает его новым значением этого поля