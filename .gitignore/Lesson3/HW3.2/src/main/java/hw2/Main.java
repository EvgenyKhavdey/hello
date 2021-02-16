package hw2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int i = random.nextInt(25);
        question(words, i);
        sc.close();
    }
    public static void question(String[] words, int i){
        while (true) {
            System.out.println("Угадайте слово из данного рядя:\"apple\", \"orange\", \"lemon\", \"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\", \"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\", \"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pineapple\", \"pumpkin\", \"potato\" ");
            String str = words[i];
            char a = str.charAt(0);
            String str1 = sc.next();
            char b = str1.charAt(0);
            if (a == b) {
                System.out.println("Вы угадали!");
                break;
            } else {
                System.out.println("Загаданное слово " + str.charAt(0)+ "" + str.charAt(1)+ "" + "xxxxxxxxxxx");
            }
        }
    }
}
