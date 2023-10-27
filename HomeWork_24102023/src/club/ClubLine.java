package club;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ClubLine {

    private Deque<Visitor> line;

    public ClubLine() {
        this.line = new ArrayDeque<>();
    }

    public boolean goToLine(Visitor newVisitor) {
        if (newVisitor.getAge() <21){
            System.out.println("You are so young. You can`t enter to club");
            return false;
        }
        System.out.println("You can enter to club");
        return line.add(newVisitor);
    }

    public Visitor goToEnter(){
        return line.pollFirst();
    }
}
//Создайте программу Вышибала, которая обслуживает посетителей в порядке их прихода в ночной клуб. Если посетителю
// меньше 21 года, то в клуб его не пустят.