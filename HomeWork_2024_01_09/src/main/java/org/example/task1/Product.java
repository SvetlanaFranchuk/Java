package org.example.task1;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private String nameProducer;

    public Product(String name, double price, int quantity, String nameProducer) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.nameProducer = nameProducer;
    }

    private int addProduct(int count){
        return this.quantity += count;
    }

    private int sellProduct(int count){
        return this.quantity -= count;
    }

    private double getTotalPrice(){
        return this.quantity * this.price;
    }

    private double getPriceWithDiscount(int discount){
        return this.price*discount/100;
    }

    private boolean isTimeToOrder(){
        return quantity < 3;
    }

    private void printInformToInventory(){
        System.out.println("Product: " + name + "; producer: " + nameProducer + "; price: " + price +
                "; quantity: " + quantity);
    }

    private void printInformFromAccountant(){
        System.out.println("product :" + name + "; price: " + price + "; quantity: " + quantity  +
                ". Total sum : " + getTotalPrice());
    }

    private void printCheckOrder(){
        System.out.printf("product %s; producer %s; quantity %d%n", name, nameProducer, quantity);
    }

    protected void resetToZeroQuantity(){
        System.out.println("quantity reset to Zero after inventory");
        this.quantity = 0;
    }

    private void checkRevaluation(int discount){
        System.out.println("product :" + name + "; price: " + price + "; discount: " + discount +
                "; quantity: " + quantity  +
                ". Total sum : " + getTotalPrice()*discount/100);
    }
}
//Создайте класс с 10 методами и 4 приватными полями.