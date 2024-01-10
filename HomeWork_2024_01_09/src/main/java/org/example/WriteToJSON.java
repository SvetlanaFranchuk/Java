package org.example;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class WriteToJSON {
    public static String serializeObject(Object obj) throws IllegalAccessException {
        Map<String, Object> jsonMap = new HashMap<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            jsonMap.put(field.getName(), field.get(obj));
        }

        Gson gson = new Gson();
        return gson.toJson(jsonMap);
    }

}
//Создайте собственный класс для сериализации объекта из задания 1 в JSON. Используйте Reflection API для анализа
//полей объекта и их значений, чтобы динамически создавать JSON-представление объекта.