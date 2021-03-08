package hw2;

public class Main {

    public static void main (String [] args) {
        int[] ran = new int[8];
        for (int i = 0; i < ran.length; i++){

            ran[i] = i * 3;

            System.out.print(ran[i]);
        }
    }
}