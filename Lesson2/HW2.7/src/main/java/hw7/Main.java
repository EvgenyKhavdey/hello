package hw7;

public class Main {
    public static void main(String[] args) {
        int[] ran = {2, 3, 6, 1};
        int n = - 2;
        int m = ran.length;
        int[] arr = new int[m];
        for (int i = 0; i < ran.length; i++) {
            int j = i + n;
            if (n > 0) {
                if (j <= arr.length - 1) {
                    arr[j] = ran[i];
                } else {
                    j = 0;
                    arr[j] = ran[i];
                }
            } else {
              if (j < 0){
                  j = arr.length + j;
                  arr[j] = ran[i];
              } else {
                  arr[j] = ran[i];
              }
            }
        }
        for (m = 0; m < arr.length; m++){
            System.out.print(arr[m] + "");
        }
        System.out.println();
    }
}