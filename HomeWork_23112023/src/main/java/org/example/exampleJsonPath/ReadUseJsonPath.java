package org.example.exampleJsonPath;

import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadUseJsonPath {
    public static void main(String[] args) {
        try {
            List<Integer> ages = JsonPath.read(new File("Example1.json"), "$..age");
            for (Integer age:ages){
                System.out.println("Age " + age);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//№ 3 Прочитать значение поля age из файла Example1.json с помощью
// JsonPath https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path