package task2_3_Figure;

public class Triangle extends Figure implements IPrintable {
    private double side1;
    private double side2;
    private double side3;

    @Override
    public double getSquare() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    @Override
    public double getPerimeter() {
        return (this.side1 + this.side2 + this.side3);
    }

    @Override
    public void printCountParameters() {
        if (isTrianglrExist()) {
            System.out.printf("%s :\n Square: %.2f \n Perimeter: %.2f \n Side1: %.2f ; Opposite angle:  %.2f \n " +
                            "Side2: %.2f ; Opposite angle:  %.2f \n Side3: %.2f ; Opposite angle:  %.2f \n",
                    getFigureName(), getSquare(), getPerimeter(), this.side1, getOppositeAngle(this.side1, this.side2, this.side3),
                    this.side2, getOppositeAngle(this.side2, this.side1, this.side3), this.side3,
                    getOppositeAngle(this.side3, this.side2, this.side1));
        } else {
            System.out.println("A triangle with these parameters does not exist");
        }
    }

    @Override
    public void print() {

        System.out.println("\u25B3");
    }

    public Triangle(double side1, double side2, double side3) {
        super(FigureName.TRIANGLE);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getOppositeAngle(double oppositeSide, double sideOne, double sideTwo) {
        double cos = (sideOne * sideOne + sideTwo * sideTwo - oppositeSide * oppositeSide) / (2 * sideOne * sideTwo);
        return Math.toDegrees(Math.acos(cos));
    }

    public boolean isTrianglrExist() {
        if ((this.side1 + this.side2) > this.side3) return true;
        else return false;
    }
}
