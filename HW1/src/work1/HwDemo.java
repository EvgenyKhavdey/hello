package work1;

import java.util.Arrays;

public class HwDemo {
    public static void main(String[] args) {
        String[] array1 = {"Вода", "Огонь", "Земля"};
        Hw1<String> v = new Hw1<>(array1);
        Integer[] array2 = {1, 2, 3, 4, 5};
        Hw1<Integer> d = new Hw1<>(array2);
        System.out.println(Arrays.toString(v.replacement()));
        System.out.println(Arrays.toString(d.replacement()));

    }

}