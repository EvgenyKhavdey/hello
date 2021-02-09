import model.Cat;
import model.Plate;

public class Main {

//    Задание 5
    public static void main(String[] args){
        Cat [] cat = new Cat[4];
        cat[0] = new Cat("Barsik", 10);
        cat[1] = new Cat("Murzik", 15);
        cat[2] = new Cat("Markiz", 5);
        cat[3] = new Cat("Vasy", 20);
        Plate plate = new Plate(30);
//        plate.info();
//        plate.eat(cat);
//        cat.eat(plate);
//        plate.info();

        for (int i = 0; i < cat.length; i++){
            plate.eat(cat[i]);
            cat[i].eat(plate);
            plate.info();
        }
    }
}
