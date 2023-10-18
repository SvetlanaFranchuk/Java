package task2_3_Figure.shapes;

public class Rectangle extends Figure {
    private double length;
    private double width;

    @Override
    public double getSquare() {
        return this.length * this.width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Diagonal: %.2f \n Length:  %.2f \n Width:  %.2f",
                                                 getDiagonal(), getLength(), getWidth());
    }

    @Override
    public void print() {
        System.out.println("\u2395");
    }

    public Rectangle(double length, double width) {
        super(FigureName.RECTANGLE);
        this.length = length;
        this.width = width;
    }

    public double getDiagonal(){
        return Math.sqrt(this.length * this.length + this.width * this.width);
    }

    public  double getLength(){
        return (this.length>this.width)?this.length:this.width;
    }

    public  double getWidth(){
        return (this.length>=this.width)?this.width:this.length;
    }
}
