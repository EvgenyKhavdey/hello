package proba;

import java.util.Random;
import java.util.Scanner;

public class proba {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char [][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main (String[]args) {
        initMap();
        printMap();
        while (true) {
            humanTurt();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapfull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интелект");
                break;
            }
            if (isMapfull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static boolean checkWin (char symb){
        int x = 0;
        for (int i = 0; i < SIZE; i++){
            x =0;
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == symb) {
                    x = x + 1;
                } else {
                    x = 0;
                }
                if (x == 3){
                    return true;
                }
            }

        }
        x = 0;
        for (int j = 0; j < SIZE; j++){
            x =0;
            for (int i = 0; i < SIZE; i++){
                if (map[i][j] == symb) {
                    x = x + 1;
                } else {
                    x = 0;
                }
                if (x == 3){
                    return true;
                }
            }
        }
        x = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == symb) {
                        x = x + 1;
                    } else {
                        x = 0;
                    }
                    if (x == 3){
                        return true;
                    }
                }

            }

        }
        x = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - j - 1){
                    if (map[i][j] == symb) {
                        x = x + 1;
                    } else {
                        x = 0;
                    }
                    if (x == 3){
                        return true;
                    }

                }

            }
        }
        return false;
    }

    public static boolean isMapfull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        int c = 0;
        if (map[1][1] == DOT_EMPTY){
            x = 1;
            y = 1;
            System.out.println("Компьютер походил в точку" + (x + 1) + " " + (y + 1));
            map[1][1] = DOT_O;
        } else if(map[1][1] == DOT_X && map[0][0] == DOT_EMPTY) {
            x = 0;
            y = 0;
            System.out.println("Компьютер походил в точку" + (x + 1) + " " + (y + 1));
            map[0][0] = DOT_O;
        }else {
            int a = 0;
            int b = 0;
//            диагональ 1
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (i == SIZE - j - 1) {
                        if (map[i][j] == DOT_X) {
                            a = a + 1;
                        } else if (map[i][j] == DOT_O) {
                            b = b + 1;
                        }
                    }
                }
            }
            if (a == 2 && b == 0) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (i == SIZE - j - 1) {
                            if (map[i][j] == DOT_EMPTY) {
                                System.out.println("Компьютер походил в точку" + (i + 1) + " " + (j + 1));
                                map[i][j] = DOT_O;
                                c = 1;
                                break;
                            }
                        }
                    }
                }
            }
            a = 0;
            b = 0;
//            диагональ 2
            if (c < 1) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (i == j) {
                            if (map[i][j] == DOT_X) {
                                a = a + 1;
                            } else if (map[i][j] == DOT_O) {
                                b = b + 1;
                            }
                        }
                    }
                }
                if (a == 2 && b == 0) {
                    for (int i = 0; i < SIZE; i++) {
                        for (int j = 0; j < SIZE; j++) {
                            if (i == j) {
                                if (map[i][j] == DOT_EMPTY) {
                                    System.out.println("Компьютер походил в точку" + (i + 1) + " " + (j + 1));
                                    map[i][j] = DOT_O;
                                    c = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            a = 0;
            b = 0;
//           строки
            if (c < 1) {
                for (int i = 0; i < SIZE; i++) {
                    a = 0;
                    b = 0;
                    for (int j = 0; j < SIZE; j++) {
                        if (map[i][j] == DOT_X) {
                            a = a + 1;
                        } else if (map[i][j] == DOT_O) {
                            b = b + 1;
                        }

                    }
                    if (a == 2 && b == 0) {
                        if (c < 1) {
                            for (int g = 0; g < SIZE; g++) {
                                if (map[i][g] == DOT_EMPTY) {
                                    System.out.println("Компьютер походил в точку" + (i + 1) + " " + (g + 1));
                                    map[i][g] = DOT_O;
                                    c = 1;
                                    break;
                                }
                            }
                        }
                    }

                }
            }
            a = 0;
            b = 0;
//          столбцы
            if (c < 1) {
                for (int j = 0; j < SIZE; j++) {
                    a = 0;
                    b = 0;
                    for (int i = 0; i < SIZE; i++) {
                        if (map[i][j] == DOT_X) {
                            a = a + 1;
                        } else if (map[i][j] == DOT_O) {
                            b = b + 1;
                        }
                    }
                    if (a == 2 && b == 0) {
                        if (c < 1) {
                            for (int h = 0; h < SIZE; h++) {
                                if (map[h][j] == DOT_EMPTY) {
                                    System.out.println("Компьютер походил в точку" + (h + 1) + " " + (j + 1));
                                    map[h][j] = DOT_O;
                                    c = 1;
                                    break;
                                }
                            }
                        }
                    } else {
                        a = 0;
                        b = 0;
                    }
                }
            }
            if (c < 1) {
                do {
                    x = rand.nextInt(SIZE);
                    y = rand.nextInt(SIZE);
                } while (!isCellValid(x, y));
                System.out.println("Компьютер походил в точку" + (x + 1) + " " + (y + 1));
                map[y][x] = DOT_O;
            }
        }
    }
    public static void humanTurt() {
        int x, y;
        do {
            System.out.println("Введите координаты X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y){
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <=SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


