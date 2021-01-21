package hw1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Необходимо отгадать число от 0 до 9");
        int[] arrs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        int i = random.nextInt(10);
        playLevel(arrs, i);
        sc.close();
    }
    public static void playLevel(int[]arrs, int i){
        int x = 0;
        int n = 2;
        int sun;
        while (true){
            System.out.println("Угадайте число от 0 до 9");
                int j = sc.nextInt();
                if (j == arrs[i]){
                    System.out.println("Вы угадали");
                    break;
                } else if (j > arrs[i]){
                    System.out.println("Загаданое число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
                if (x < 2){
                    sun = n - x;
                    System.out.println("У вас осталось " + sun + " попыток");
            } else {
                System.out.println("Вы не угадали");
                break;
            }
            x = x + 1;
        }
        play(arrs, i);
    }
    public static void play (int[] arrs,int i){
        System.out.println("Повторить игру еще раз?");
        System.out.println("1 - повторить, 0 -нет");
        int j = sc.nextInt();
        if (j == 1){
            playLevel(arrs, i);
        }
    }
}
