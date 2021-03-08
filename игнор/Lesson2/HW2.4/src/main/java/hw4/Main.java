package hw4;

public class Main {

    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 2;
                if (i == j) {
                    arr[i][j] = 1;
                }
                if (i == (arr.length - j - 1)){
                    arr[i][j] = 1;
                }

                System.out.print(arr[i][j]);
                System.out.print(" ");

            }
        System.out.println();
        }

    }
}
