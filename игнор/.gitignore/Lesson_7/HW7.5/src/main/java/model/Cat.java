package model;

public class Cat {
    protected static String name;
    private int appetite;
    public boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p){
        p.decreseFood(appetite);
    }



    public void satietyCat(int c){
        if (c >= appetite){
            satiety = true;
        }
        System.out.println(satiety + " " + name);
    }

}
