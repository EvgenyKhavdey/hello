public class Main {
    public static void main(String[] args){
        Integer[] arrey = {1, 30, 82, 54, 68, 160, 201};
        MyInter s = x -> {
            int max = arrey[0];
            for (int i = 0; i < arrey.length; i++) {
                if(arrey[i] > max){
                    max= arrey[i];
                }
            }
            return max;
        };
        int r = s.maximum(arrey);
        System.out.println(r);
    }
}
