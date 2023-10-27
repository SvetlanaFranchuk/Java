package club;

public class MainClub {
    public static void main(String[] args) {
        int maxCountVisitor = 10;
        int count = 0;
        while (count <= maxCountVisitor) {
            Visitor visitor = new Visitor();
            ClubLine clubLine = new ClubLine();
            System.out.println(visitor);
            if (clubLine.goToLine(visitor)) {
                clubLine.goToEnter();
                count++;
            }
            System.out.println("____________");
           ;
        }
    }
}
