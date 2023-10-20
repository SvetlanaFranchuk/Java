package task2_3_Figure.shapes;

public class Ellipse extends Figure {
    private double bigAxis;
    private double smallAxis;

    @Override
    public double getSquare() {
        return Math.PI * this.bigAxis / 2 * this.smallAxis / 2;
    }

    @Override
    public double getPerimeter() {
        return 4 * (Math.PI * this.bigAxis / 2 * this.smallAxis / 2 + (this.bigAxis / 2 - this.smallAxis / 2)) / ((this.bigAxis / 2 + this.smallAxis / 2));
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Big axis: %.2f \n Small axis:  %.2f",
                                     this.bigAxis, this.smallAxis);
    }

    @Override
    public void print() {
        System.out.println("\u2B2D");
    }

    public Ellipse(double bigAxis, double smallAxis) {
        super(FigureName.ELLIPSE);
        if (bigAxis > smallAxis) {
            this.bigAxis = bigAxis;
            this.smallAxis = smallAxis;
        } else {
            this.bigAxis = smallAxis;
            this.smallAxis = bigAxis;
        }
        ;
    }


}
