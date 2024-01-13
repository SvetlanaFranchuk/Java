package org.example.task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};

        Map<String, Set<String>> wordToChars = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Set<String> treeSet = new TreeSet<>();
            for (char c : charArray) {
                treeSet.add("" + c);
            }
            wordToChars.put(word, treeSet);
        }

        Map<Set<String>, List<String>> result = new HashMap<>();
        wordToChars.forEach((k,v)->{
            List<String> list = new ArrayList<>();
            if (result.get(v) != null) {
                list = result.get(v);
            }
            list.add(k);
            result.put(v, list);
        });

        result.forEach((k,v)-> System.out.println(k+" "+v));
    }

}
//Сгруппируйте слова с одинаковым набором символов
//    Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым уникальным набором символов.
//
//
//        - Input: String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
//        - Output :
//        student, students
//        cat, act, tact
//        dog, god
//        flow, wolf
//        - (Набор букв 1 группы: s, t, u, d, e, n, t; 2 группы: a, c, t; 3 группы: d, o, g; 4 группы: f, l, o, w)
//        - Группы слов функция возвращает в виде List>, либо сразу печатает в консоль.