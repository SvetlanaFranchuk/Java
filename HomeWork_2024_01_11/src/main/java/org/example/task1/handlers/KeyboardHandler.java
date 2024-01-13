package org.example.task1.handlers;

import org.example.task1.reflect.EventHandler;

import java.security.Key;

@EventHandler
public class KeyboardHandler {
    private void exampleOnKeyPress(Key key){
        System.out.println("The player pressed a keyboard key");
    }
}
