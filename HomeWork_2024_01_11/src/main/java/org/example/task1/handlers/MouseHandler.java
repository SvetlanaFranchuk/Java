package org.example.task1.handlers;

import org.example.task1.reflect.EventHandler;

@EventHandler
public class MouseHandler {
    public void exampleOnMouseLeftClick(int x, int y){
        System.out.printf("Player left-clicked on the coordinate ($d,$d)$n",x,y);
    }

    public void exampleOnMouseRightClick(int x, int y){
        System.out.printf("Player right-clicked on the coordinate ($d,$d)$n",x,y);
    }
}
