package task2_3_Figure;

public class Ellipse extends Figure implements IPrintable {
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
    public void printCountParameters() {
        System.out.printf("%s :\n Square: %.2f \n Perimeter: %.2f \n Big axis: %.2f \n Small axis:  %.2f \n",
                getFigureName(), getSquare(), getPerimeter(), this.bigAxis, this.smallAxis);
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
