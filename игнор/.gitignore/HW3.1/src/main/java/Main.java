import java.util.*;

public class Main {
    public static void main(String[] args){

        String[] arr = new String[]{"Яблоко", "Груша", "Лук", "Картошка", "Яблоко", "Вишня", "Лук", "Апельсин", "Ананас", "Огурец", "Гранат", "Яблоко", "Ананас", "Мандарин", "Слива"};
        System.out.println(Arrays.toString(arr));
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        System.out.println("");
        System.out.println("Выводим на экран список уникальных слов");
        System.out.println(set);
        System.out.println("");
        System.out.println("Посчитаем сколько раз встречается каждое слово");
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        while (list.size() != 0){
            Iterator<String> iter = list.iterator();
            String str = iter.next();
            iter.remove();
            int n = 1;
            while (iter.hasNext()){
                if(str.equals(iter.next())){
                    n = n + 1;
                    iter.remove();
                }
            }
            System.out.println(str + " истречается " + n + " раз(раза)" );
        }
    }
}
