package model;

import actions.Track;
import actions.Wall;

public class Robot {
    private String mfr;
    private int west;

    public Robot(String mfr, int west){
        this.mfr = mfr;
        this.west = west;
    }
    public void run(int x){
        west = west - x;
    }

    public void bounce(float x){
        if (x >= 0.5){
            west = 0;
        }
        west = west - 10;
    }
    public void overcomingObstaclesRobot(Object[] obj1){
        for (int i = 0; i < obj1.length; i++) {
            if (west > 0) {
                if (obj1[i] instanceof Track) {
                    run(((Track) obj1[i]).getLength());
                } else if (obj1[i] instanceof Wall) {
                    bounce(((Wall) obj1[i]).getHeight());
                }
            } else {
                System.out.println("У " + mfr + " не хватило сил пробежать полосу препятствий");
                break;
            }
        }
        System.out.println(mfr + " преодолел полосу препятствий");
    }
}
