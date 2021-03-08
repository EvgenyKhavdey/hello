import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      String str = "java interview";
      int b = str.length();
      MyInter d = x ->{
          String r = " ";
          for (int i = 0; i < str.length(); i++) {
              r = str.charAt(i) + r;
          }
          return r;
      };
      System.out.println(d.reverse(str));
    }
}
