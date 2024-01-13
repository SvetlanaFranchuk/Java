package org.example.task1.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class EventProcessor {
    public static void main(String[] args) {
        List<Class<?>> list = ReflectionHelper.findAnnotated("org.example.task1.handlers", EventHandler.class);
        for (Class<?> aClass : list) {
            System.out.println("Class: " + aClass.toString());
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                String name = method.getName();
                String returnType = method.getReturnType().getSimpleName();
                List<String> inputTypes = Arrays.stream(method.getParameterTypes()).map(Class::getSimpleName).toList();
                List<String> exceptionTypes = Arrays.stream(method.getExceptionTypes()).map(Class::getSimpleName).toList();
                System.out.printf("     Method: %s, return type %s, params %s, exceptions %s%n", name, returnType, inputTypes, exceptionTypes);
            }
        }
    }
}
