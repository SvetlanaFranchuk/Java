package task2_3_Figure.shapes;

import task2_3_Figure.IPrintable;

public abstract class Figure implements IPrintable {
    private FigureName figureName;
    public abstract double getSquare();
    public abstract double getPerimeter();

    public FigureName getFigureName() {
        return figureName;
    }

    public Figure(FigureName figureName) {
        this.figureName = figureName;
    }

    @Override
    public String toString() {
        return  String.format("%s :\n Square: %.2f \n Perimeter: %.2f \n ",
                getFigureName(), getSquare(), getPerimeter());
    }

    @Override
    public void print() {

    }

}
