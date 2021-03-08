package model;

public class Robot {
    private String mfr;
    private int west;

    public Robot(String mfr, int west){
        this.mfr = mfr;
        this.west = west;
    }
    public void run(int x){
        int y = x - west;
        if (y > 0){
            System.out.println("У робота производства " + mfr + " не хватило сил пробежать дорожку" );
            return;
        }
        System.out.println("Робот производства " + mfr + " пробежал дорожку");
    }

    public void bounce(float x){
        if (x >= 0.5){
            System.out.println("Стена слишком высокая робот производств " + mfr + " не может перепрыгнуть");
            return;
        }
        System.out.println("Робот производства " + mfr + " перепрыгнул стену");
    }

}
