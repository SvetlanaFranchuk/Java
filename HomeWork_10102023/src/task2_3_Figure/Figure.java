package task2_3_Figure;

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

    public abstract void printCountParameters();

    @Override
    public void print() {

    }

}
