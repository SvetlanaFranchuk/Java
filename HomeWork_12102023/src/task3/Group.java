package task3;

import java.util.ArrayList;
import java.util.List;

public class Group {
    //Создайте класс Group, который хранит фамилии всех студентов в учебной группе. В классе напишите метод,
    // который по заданным первым буквам фамилии находит всех студентов и возвращает результат в виде списка.
    // Вызовите метод в main
    private List<String> list = new ArrayList<>();

    public Group(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public static List<String> getListOfFio (String partSurname, Group group){
        List<String> list1 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < group.getList().size(); i++) {
            if (group.getList().get(i).indexOf(partSurname)==0) {
                list1.add(count, group.getList().get(i));
                count ++;
            }
        }
        return list1;
    }
}
