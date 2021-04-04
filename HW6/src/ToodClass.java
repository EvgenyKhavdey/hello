public class ToodClass {
    public static int[] mass1(int[] arr){
        int flag = arr[0];
        int t = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                flag = i;
            }
        }
        int[] arrs = new int[arr.length - flag - 1];
        for (int i = 0; i < arr.length; i++) {
            if(t == 1){
                arrs[i - flag - 1] = arr[i];
            }
            if(i == flag){
                t = 1;
            }
        }
        return arrs;
    }
    public static boolean mass2(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1 || arr[i] == 4){
                return true;
            }
        }
        return false;
    }
}
