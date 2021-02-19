package model;

public class Person {
    private String name;
    private int force;

    public Person(String name, int force){
        this.name = name;
        this.force = force;
    }

    public void run(int x){
        int y = x - force;
        if (y > 0){
            System.out.println("У " + name + " не хватило сил пробежать дорожку" );
            return;
        }
        System.out.println(name + " пробежал дорожку");
    }

    public void bounce(float x){
        if (x >= 2){
            System.out.println("Стена слишком высокая " + name + " не может перепрыгнуть");
            return;
        }
        System.out.println(name + " перепрыгнул стену");
    }
}
