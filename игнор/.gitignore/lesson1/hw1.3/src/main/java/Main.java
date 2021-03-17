import actions.Track;
import actions.Wall;
import model.Cat;
import model.Person;
import model.Robot;

public class Main {
    public static void main(String[] args){
        Object [] obj = new Object[10];
        obj[0] = new Person("Trump", 400);
        obj[1] = new Cat("Myrzik", 200);
        obj[2] = new Robot("Tesla", 500);
        obj[3] = new Person("Biden", 200);
        obj[4] = new Cat("Barsik", 150);
        obj[5] = new Robot("Samsung", 70);
        obj[6] = new Person("Merkel", 150);
        obj[7] = new Cat("Baron", 500);
        obj[8] = new Robot("Simens", 120);
        obj[9] = new Person("Obama",500);

        Object [] obj1 = new Object[5];
        obj1[0] = new Track(40);
        obj1[1] = new Wall(0.4f);
        obj1[2] = new Wall(0.2f);
        obj1[3] = new Track(80);
        obj1[4] = new Track(110);


        for (int i = 0; i < obj.length; i++) {
                if (obj[i] instanceof Person){
                    ((Person)obj[i]).overcomingObstaclesPercon(obj1);
                } else if (obj[i] instanceof Cat){
                    ((Cat)obj[i]).overcomingObstaclesCat(obj1);
                } else if (obj[i] instanceof Robot){
                    ((Robot)obj[i]).overcomingObstaclesRobot(obj1);
                }
        }
        
    }
}
