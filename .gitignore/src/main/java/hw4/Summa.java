public class Summa {
//     задание 1.4
    public static void summa (String [] args){
        System.out.println(checkNumber());
    }

    public static boolean checkNumber(int a, int b){
        int sum = a + b;
        if (sum >= 10 && sum <= 20){
            return true;
        } else {
            return false;
        }
    }
}
