import actions.Track;
import actions.Wall;
import model.Cat;
import model.Person;
import model.Robot;

public class Main {
    public static void main(String[] args){
        Object [] obj = new Object[10];
        obj[0] = new Person("Trump", 300);
        obj[1] = new Cat("Myrzik", 100);
        obj[2] = new Robot("Tesla", 50);
        obj[3] = new Person("Biden", 200);
        obj[4] = new Cat("Barsik", 150);
        obj[5] = new Robot("Samsung", 70);
        obj[6] = new Person("Merkel", 150);
        obj[7] = new Cat("Baron", 50);
        obj[8] = new Robot("Simens", 120);
        obj[9] = new Person("Obama",500);

        Object [] obj1 = new Object[5];
        obj1[0] = new Track(40);
        obj1[1] = new Wall(0.4f);
        obj1[2] = new Wall(1f);
        obj1[3] = new Track(400);
        obj1[4] = new Track(110);

        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj1.length; j++) {
                if (obj[i] instanceof Person){
                    if (obj1[j] instanceof Track){
                        ((Person)obj[i]).run(((Track)obj1[j]).getLength());
                    } else if (obj1[j] instanceof Wall) {
                        ((Person) obj[i]).bounce(((Wall) obj1[j]).getHeight());
                    }
                } else if (obj[i] instanceof Cat){
                    if (obj1[j] instanceof Track){
                        ((Cat)obj[i]).run(((Track)obj1[j]).getLength());
                    } else if (obj1[j] instanceof Wall) {
                        ((Cat) obj[i]).bounce(((Wall) obj1[j]).getHeight());
                    }
                } else if (obj[i] instanceof Robot){
                    if (obj1[j] instanceof Track){
                        ((Robot)obj[i]).run(((Track)obj1[j]).getLength());
                    } else if (obj1[j] instanceof Wall) {
                        ((Robot) obj[i]).bounce(((Wall) obj1[j]).getHeight());
                    }
                }
            }

        }
        
    }
}
