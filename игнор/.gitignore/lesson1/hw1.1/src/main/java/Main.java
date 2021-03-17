import actions.Track;
import actions.Wall;
import model.Cat;
import model.Person;
import model.Robot;

public class Main {
    public static void main(String[] args){
        Person a = new Person("Trump", 300);
        Cat b = new Cat("Myrzik", 100);
        Robot c = new Robot("Tesla", 50);
        Track v = new Track(40);
        Wall w = new Wall(0.4f);
        a.run(v.getLength());
        b.run(v.getLength());
        c.run(v.getLength());
        a.bounce(w.getHeight());
        b.bounce(w.getHeight());
        c.bounce(w.getHeight());
    }
}
