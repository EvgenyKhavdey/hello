import model.Cat;
import model.Plate;

public class Main {

//    Задание 1,2,3,4

    public static void main(String[] args){
        Cat cat = new Cat("Barsik", 20);
        Plate plate = new Plate(15);
        plate.info();
        plate.eat(cat);
        cat.eat(plate);
        plate.info();
    }

}
