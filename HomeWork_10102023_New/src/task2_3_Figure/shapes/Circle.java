package task2_3_Figure.shapes;

public class Circle extends Figure {
    private double radius;

    @Override
    public double getSquare() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Radius: %.2f \n Diametr:  %.2f", radius, radius * 2);
    }

    @Override
    public void print() {
        System.out.println("\u25EF");
    }

    public Circle(double radius) {
        super(FigureName.CIRCLE);
        this.radius = radius;
    }


}
