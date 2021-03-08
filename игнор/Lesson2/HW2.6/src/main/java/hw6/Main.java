package hw6;

public class Main {
    public static void main (String[] args){
        int n;
        int[] checkBalance = {2, 2, 2, 1, 2, 2, 10, 1};
        n = checkBalance.length;
        int x = 0;
        for (int i = 0; i < checkBalance.length; i++){
            x = x + checkBalance[i];
            int y = 0;
            for (int j = checkBalance.length - 1; j > 0; j--){
                y = y + checkBalance[j];
                if (x == y){
                    if (n == i + (n - j + 1)){
                        System.out.println(true);
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}
