package org.example.wrongPractice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1,"Mark", "Twain", 1000, LocalDate.of(1984,11,5));
        Employee employee2 = new Employee(2,"James", "Bell", 1200, LocalDate.of(1968,12,21));
        Employee employee3 = new Employee(3,"Justin", "Morton", 900, LocalDate.of(1973,10,7));
        Employee employee4 = new Employee(4,"Albert", "Nelson", 950, LocalDate.of(1993,5,12));

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        int fixBonus = 100;
        int percentBonus = 7;

        //TODO нарушен принцип KISS - расчет месячной зарплаты можно было бы вынести в отдельный метод
        System.out.println("Month salary " + employee1.getFirstName() + " " + employee1.getLastName() + ": " +
                (employee1.getSalary() + fixBonus + employee1.getSalary()*percentBonus/100));
        System.out.println("Month salary " + employee2.getFirstName() + " " + employee2.getLastName() + ": " +
                (employee2.getSalary() + fixBonus + employee2.getSalary()*percentBonus/100));
        System.out.println("Month salary " + employee3.getFirstName() + " " + employee3.getLastName() + ": " +
                (employee3.getSalary() + fixBonus + employee3.getSalary()*percentBonus/100));
        System.out.println("Month salary " + employee4.getFirstName() + " " + employee4.getLastName() + ": " +
                (employee4.getSalary() + fixBonus + employee4.getSalary()*percentBonus/100));


    }

    //TODO нарушен принцип YAGNI. Метод maxAgeInCurrentYear нигде не используется
    public static int maxAgeInCurrentYear (List<Employee> employees){
        int result = LocalDate.now().getYear(); //TODO нарушен принцип РОLA, переменную лучше было бы назвать currentYear
        int maxYear = employees.get(0).getBirth().getYear();
        for (Employee employee: employees) {
            if (employee.getBirth().getYear() >maxYear) maxYear = employee.getBirth().getYear();
        }
        return result - maxYear;
    }


}
//Напишите примеры классов/интерфейсов/отдельных методов с нарушением изученных лучших практик (4-5 нарушений).
// В комментариях, начинающихся с TODO,  укажите, какой принцип был нарушен. Получившийся проект направьте на проверку.
