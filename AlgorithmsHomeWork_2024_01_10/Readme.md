# Homework 10.01.2024

***Описание задания.***

### Task 1. 
Для класса Book с полями String name, double price, boolean isPresent
реализовать методы equals(Object o), hashCode(), compareTo(Book another)

### Task 2. 
Проверьте, равны ли два массива или нет
Учитывая два массива, arr1 и arr2 одинаковой длины N, задача состоит в том, чтобы определить, равны ли данные массивы 
или нет.


***Два массива называются равными, если:
оба они содержат один и тот же набор элементов, расположение (или перестановки) элементов может/не может быть одинаковым.
Если есть повторения, то количество повторяющихся элементов также должно быть одинаковым, чтобы два массива были равны.***
- Ввод: arr1[] = {1, 2, 5, 4, 0, 0}, arr2[] = {0, 2, 4, 5, 0, 1}
- Вывод: Да
- Неоптимальное решение задачи написано на занятии (см. CompareArrays.java).
- Необходимо предложить решение сложности O(n).


### Task 3. 
Сгруппируйте слова с одинаковым набором символов
Дан список слов со строчными буквами. Реализуйте функцию поиска всех слов с одинаковым уникальным набором символов.


- Input: String words[] = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf", "tact"};
- Output :
student, students
cat, act, tact
dog, god
flow, wolf
- (Набор букв 1 группы: s, t, u, d, e, n, t; 2 группы: a, c, t; 3 группы: d, o, g; 4 группы: f, l, o, w)
- Группы слов функция возвращает в виде List>, либо сразу печатает в консоль.

