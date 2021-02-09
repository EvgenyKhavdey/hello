package hw5;

public class Main {
    public static void main (String[] args) {
        int[] ram = {10, 12, 26, 8, 21, 16, 15, 7, 8, 3};
        int x = 0;
        int y = 0;
        int max;
        max = ram[0];
        int min;
        min = ram[0];
        while (x < 10){
            for (int i = x; i < ram.length; i++ ){
                if (ram[x] < ram[i]){
                    if (max < ram[i]) {
                        max = ram[i];
                    }
                }
            }
            x = x + 1;

        }
        System.out.println("Максимальное число = " + max);

        while (y < 10){
            for (int i = y; i < ram.length; i++ ){
                if (ram[y] > ram[i]){
                    if (min > ram[i]) {
                        min = ram[i];
                    }
                }
            }
            y = y + 1;

        }

        System.out.println("Минимальное число = " + min);


    }
}
