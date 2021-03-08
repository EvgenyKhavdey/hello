import a.Animal;
import a.Cat;
import a.Dog;

import java.util.Scanner;
public abstract class Main {

    public static void main(String[] args){
        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal animal = new Animal();
        dog.dogRun();
        cat.catRun();
        do {
        } while (!recording());
        animal.counter();

    }


    public static boolean recording (){
        Dog dog = new Dog();
        Cat cat = new Cat();
        System.out.println("Хотите записать еще животное?");
        System.out.println("0 -нет, 1 - собаку, 2 - кошку");
        Scanner sc = new Scanner(System.in);
        int j = sc.nextInt();
        if (j == 1) {
            dog.dogRun();
        } else if (j == 2){
            cat.catRun();
        } else if (j == 0){
            return true;
        }
        return false;
    }

}
