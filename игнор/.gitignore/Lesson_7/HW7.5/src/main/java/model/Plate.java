package model;

public class Plate {


    protected int volume;

    public Plate(int volume) {
        this.volume = volume;

    }

    public void decreseFood(int n) {
        if (volume >= n) {
            volume -= n;
        } else {
            cookFood();
            volume -= n;
        }
    }

    public void eat (Cat c){
        c.satietyCat(volume);
    }

    public void info(){

        System.out.println("Тарелка: " + volume);
    }

    public int cookFood(){
        volume = volume + 40;
        return volume;
    }


}
