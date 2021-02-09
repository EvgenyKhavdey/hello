package model;

public class Plate  {

    private int volume;


    public Plate(int volume) {
        this.volume = volume;
    }

    public void decreseFood(int n) {
        if (volume > n) {
            volume -= n;
        } else {
            Cat.infoCat();
        }

    }


    public void eat (Cat c){
        c.satietyCat(volume);
    }

    public void info(){

        System.out.println("Тарелка: " + volume);
    }
}
