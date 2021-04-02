import A.Car;
import A.Race;
import A.Road;
import A.Tunnel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        ExecutorService executor =  Executors.newFixedThreadPool(CARS_COUNT);
        final CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            executor.execute(new Car(cdl, race, 20 + (int) (Math.random() * 10)));
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
//       System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}
