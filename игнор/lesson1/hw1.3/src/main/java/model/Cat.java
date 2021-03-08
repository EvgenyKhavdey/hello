package model;

import actions.Track;
import actions.Wall;

public class Cat {
    private String nickname;
    private int force;

    public Cat(String nickname, int force){
        this.nickname = nickname;
        this.force = force;
    }
    public void run(int x) {
        force = force - x;
    }

    public void bounce(float x){
        if (x >= 1.1){
            force = 0;
        }
        force = force - 10;
    }
    public void overcomingObstaclesCat(Object[] obj1) {
        for (int i = 0; i < obj1.length; i++) {
            if (force > 0) {
                if (obj1[i] instanceof Track) {
                    run(((Track) obj1[i]).getLength());
                } else if (obj1[i] instanceof Wall) {
                    bounce(((Wall) obj1[i]).getHeight());
                }
            } else {
                System.out.println("У " + nickname + " не хватило сил пробежать полосу препятствий");
                break;
            }
        }
        System.out.println(nickname + " преодолел полосу препятствий");
    }
}


