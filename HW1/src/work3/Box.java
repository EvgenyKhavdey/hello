package work3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box {
    ArrayList<Apple> container1;
    ArrayList<Orange> container2;


    public Box() {
        this.container1 = new ArrayList<Apple>();
        this.container2 = new ArrayList<Orange>();
    }


    public void add (Fruit fruit){
        if(fruit instanceof Apple){
            container1.add(new Apple(fruit));
        } else if (fruit instanceof Orange){
            container2.add(new Orange(fruit));
        }

    }

    public int weightApple(){
        int sum = 0;
        for (int i = 0, n = container1.size(); i < n; i++){
            sum += ((Apple)container1.get(i)).getWeight();
        }
        return sum;
    }
    public int weightOrange(){
        int sum = 0;
        for (int i = 0, n = container2.size(); i < n; i++){
            sum += ((Orange)container2.get(i)).getWeight();
        }
        return sum;
    }
    public boolean isEquals(int i, int j){
        return (i == j);
    }

}
