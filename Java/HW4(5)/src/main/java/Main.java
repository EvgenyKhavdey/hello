import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 8, 15, 4, 21, 56, 35));
        MyInter s = x -> {
            Integer[] arr = new Integer[list.size()];
            list.toArray(arr);
            int c = 0;
            for (int i = 0; i < arr.length; i++) {
                 c = c + arr[i];
            }
            return c/(list.size());
        };
        System.out.println(s.average(list));
    }
}
