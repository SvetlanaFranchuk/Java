package task2_3_Figure.shapes;

public enum FigureName {
    CIRCLE(1),
    RECTANGLE(2),
    TRIANGLE(3),
    ELLIPSE(2);

    private int countParameters;

    FigureName(int countParameters) {
        this.countParameters = countParameters;
    }

    public int getCountParameters() {
        return countParameters;
    }
}
