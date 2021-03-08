import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(Arrays.asList("анод", "класс", "алмаз", "атом", "лада", "рог", "мечта"));
        MyInter s = x -> {
            String[] str = new String[list.size()];
            list.toArray(str);
            List<String> line = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                String a = String.valueOf(str[i].charAt(0));
                    if((a.equals("а")) || str[i].length() == 3){
                        line.add(str[i]);
                }
            }
            return line;
        };
          System.out.println(s.search(list));

    }
}
