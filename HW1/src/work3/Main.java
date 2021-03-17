package work3;

public class Main {
    public static void main(String[] args){
        Box box = new Box();
        Fruit a1 = new Apple();
        Fruit a2 = new Orange();
        Fruit a3 = new Apple();
        box.add(a1);
        box.add(a2);
        box.add(a3);
        System.out.println(box.weightApple());
        System.out.println(box.weightOrange());
        System.out.println(box.isEquals(box.weightApple(), box.weightOrange()));
        Fruit a4 = new Apple();
        Fruit a5 = new Apple();
        Fruit a6 = new Orange();
        Fruit a7 = new Apple();
        Fruit a8 = new Orange();
        box.add(a4);
        box.add(a5);
        box.add(a6);
        box.add(a7);
        box.add(a8);
        System.out.println(box.weightApple());
        System.out.println(box.weightOrange());
        System.out.println(box.isEquals(box.weightApple(), box.weightOrange()));
    }
}
