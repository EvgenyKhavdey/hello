package hw1;

public class Main {

    public static void main (String [] args) {
        byte[] rim = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < rim.length; i++) {

            if (rim[i] == 1) {
                    rim[i] = 0;
                } else {
                    rim[i] = 1;
                }
            System.out.println(rim[i]);
        }
    }
}
