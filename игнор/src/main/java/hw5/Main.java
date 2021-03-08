package hw5;

public class Main {

    public static void main (String [] args){
        int a;
        System.out.println(positive(20));
    }
    public static String positive(int a){

        if (a >= 0 ){
            return "Положительное число";
        } else {
            return "Отрицательное число";
        }
    }
}
