package a;

import java.util.Scanner;

public class Animal {

    public static String name;
    public static int p;
    public static Scanner sc = new Scanner(System.in);
    public static int x = 0;


    public Animal() {

    }


    public Animal(String name, int p){
        this.name = name;
        this.p = p;
    }

    public static void run(String name, int p){
        System.out.println(name + " пробeжал - " + p + " метров");
    }

    public static void sail(String name, int p){
        System.out.println(name + " проплыл - " + p + " мметров");
        x = x + 1;
    }
    public  void counter(){
        System.out.println("Вы записали " + x + " животных");
    }
}
