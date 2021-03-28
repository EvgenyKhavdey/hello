public class Main {
    private static final Object mon = new Object();
    private static char currentLetter;

    public static void main(String[] args) {
        currentLetter = 'A';
        new Thread (() -> {
            synchronized (mon) {
                try {
                        int i = 0;
                        while (i < 5){
                            while (currentLetter != 'A') {
                                mon.wait();
                            }
                            System.out.print("A");
                            i++;
                            currentLetter = 'B';
                            mon.notifyAll();
                        }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                try {
                    int i = 0;
                    while (i < 5) {
                            while (currentLetter != 'B') {
                                mon.wait();
                            }
                            System.out.print("B");
                            i++;
                            currentLetter = 'C';
                            mon.notifyAll();
                        }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                try {
                    int i = 0;
                    while (i < 5) {
                            while (currentLetter != 'C') {
                                mon.wait();
                            }
                            System.out.print("C");
                            i++;
                            currentLetter = 'A';
                            mon.notifyAll();
                        }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
