package task2_3_Figure;

public class Rectangle extends Figure implements IPrintable {
    private double length1;
    private double length2;

    @Override
    public double getSquare() {
        return this.length1 * this.length2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.length1 + this.length2);
    }

    @Override
    public void printCountParameters() {
        System.out.printf("%s :\n Square: %.2f \n Perimeter: %.2f \n Diagonal: %.2f \n Length:  %.2f \n Width:  %.2f \n",
                getFigureName(), getSquare(), getPerimeter(), getDiagonal(), getLength(), getWidth());
    }

    @Override
    public void print() {
        System.out.println("\u2395");
    }

    public Rectangle(double length1, double length2) {
        super(FigureName.RECTANGLE);
        this.length1 = length1;
        this.length2 = length2;
    }

    public double getDiagonal(){
        return Math.sqrt(this.length1 * this.length1 + this.length2 * this.length2);
    }

    public  double getLength(){
        return (this.length1>this.length2)?this.length1:this.length2;
    }

    public  double getWidth(){
        return (this.length1>=this.length2)?this.length2:this.length1;
    }
}
