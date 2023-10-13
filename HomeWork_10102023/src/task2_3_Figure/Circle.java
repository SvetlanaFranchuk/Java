package task2_3_Figure;

public class Circle extends Figure implements IPrintable {
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
    public void printCountParameters() {
        System.out.printf("%s :\n Square: %.2f \n Perimeter: %.2f \n Radius: %.2f \n Diametr:  %.2f \n",
                getFigureName(), getSquare(), getPerimeter(), radius, radius * 2);
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
