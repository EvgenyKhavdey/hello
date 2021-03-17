package model;

import actions.Track;
import actions.Wall;

public class Person {
    private String name;
    private int force;


    public Person(String name, int force){
        this.name = name;
        this.force = force;
    }


    public void run(int x){
        force = force - x;
    }

    public void bounce(float x){
        if (x >= 2){
            force = 0;
        }
        force = force - 10;
    }

    public void overcomingObstaclesPercon(Object[] obj1) {
        for (int i = 0; i < obj1.length; i++) {
            if (force > 0) {
                if (obj1[i] instanceof Track) {
                    run(((Track) obj1[i]).getLength());
                } else if (obj1[i] instanceof Wall) {
                    bounce(((Wall) obj1[i]).getHeight());
                }
            } else {
                System.out.println("У " + name + " не хватило сил пробежать полосу препятствий" );
                break;
            }
        }
        System.out.println(name + " преодолел полосу препятствий");
    }

}



