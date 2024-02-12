package org.example.dto;

public class UserSession {
    private boolean isNewUser;

    public UserSession() {
        this.isNewUser = true;
    }

    public String getWelcomeMessage() {
        if (isNewUser) {
            return "Welcome, new user!";
        } else {
            return "Welcome back!";
        }
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }
}
