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

    public static void infoCat(){
        System.out.println("В тарелке мало еды " + name + " остался голодным");
    }

    public void satietyCat(int c){
        if (c > appetite){
            satiety = true;
        }
        System.out.println(satiety);
    }

}
