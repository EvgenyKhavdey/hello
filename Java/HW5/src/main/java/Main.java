public class Main {
    public static void main(String[] args){
        Thread t1 = new Thread(new TestThread());
        Thread t2 = new Thread(new TestThreadMethod2());
        t1.start();
        t2.start();
    }
}
