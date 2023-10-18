package task2_3_Figure.shapes;

public class Triangle extends Figure {
    private double side1;
    private double side2;
    private double side3;
    private double angle1;
    private double angle2;
    private double angle3;


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
    public String toString() {
        if (isTrianglrExist()) {
        return super.toString() + String.format("Side1: %.2f ; Opposite angle:  %.2f \n " +
                                                "Side2: %.2f ; Opposite angle:  %.2f \n " +
                                                "Side3: %.2f ; Opposite angle:  %.2f",
                                            this.side1, this.angle1, this.side2, this.angle2,
                                            this.side3, this.angle3);
                                } else {
                                return  "A triangle with these parameters does not exist";
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
        this.angle1 = getOppositeAngle(this.side1, this.side2, this.side3);
        this.angle2 = getOppositeAngle(this.side2, this.side1, this.side3);
        this.angle3 = getOppositeAngle(this.side3, this.side2, this.side1);
    }

    public double getOppositeAngle(double oppositeSide, double sideOne, double sideTwo) {
        double cos = (sideOne * sideOne + sideTwo * sideTwo - oppositeSide * oppositeSide) / (2 * sideOne * sideTwo);
        return Math.toDegrees(Math.acos(cos));
    }

    public boolean isTrianglrExist() {
        if ((this.side1 + this.side2) > this.side3 &&
            (this.side2 + this.side3) > this.side1 &&
            (this.side1 + this.side3) > this.side2
        ) return true;
        else return false;
    }
}
