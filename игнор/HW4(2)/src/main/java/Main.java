import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int a = 0;
        MyInter s = (x,y) -> list.get(x);
        a = s.search(2, list);
        System.out.println(a);
    }
}
