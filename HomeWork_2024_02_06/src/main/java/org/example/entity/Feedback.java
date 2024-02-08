package org.example.entity;

public class Feedback {
    private Product product;
    private User user;
    private int rate;
    private String message;

    public Feedback(Product product, User user, int rate, String message) {
        this.product = product;
        this.user = user;
        this.rate = rate;
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
