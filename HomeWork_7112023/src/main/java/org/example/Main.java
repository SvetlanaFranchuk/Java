package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChildrenGames childrenGames1 = new ChildrenGames("Twister", 7, 95.5);
        ChildrenGames childrenGames2 = new ChildrenGames("Sea battle", 5, 65);
        ChildrenGames childrenGames3 = new ChildrenGames("Lego city (600)", 5, 135);

        List<ChildrenGames> list = new ArrayList<>();
        list.add(childrenGames1);
        list.add(childrenGames2);
        list.add(childrenGames3);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() > 100)
                System.out.println(list.get(i));
            if (!(list.get(i).equals(null)))
                System.out.println("method equals is available");
            System.out.println("hash code = "+list.get(i).hashCode());
        }


    }
}