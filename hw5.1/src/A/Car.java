package A;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    CountDownLatch cdl;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(CountDownLatch cdl, Race race, int speed) {
        this.cdl = cdl;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов");
                Thread.sleep(1000 + (int) (Math.random() * 800));
            } catch (Exception e) {
                e.printStackTrace();
            }
            ATM.getSynch();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            ATM.getWin(this.name);
            cdl.countDown();
    }


}
