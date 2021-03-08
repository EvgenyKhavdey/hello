package hw3;

public class Main {
    public static void main(String[] args) {
        int[] ram = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (byte i = 0; i < ram.length; i++){
            if (ram[i] < 6) {
                ram[i] = ram[i] * 2;
            }
            System.out.println(ram[i]);
        }
    }
}
