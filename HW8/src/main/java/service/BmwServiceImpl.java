package service;

public class BmwServiceImpl implements CarService {
    @Override
    public void start() {
        System.out.println("Bmw start");
    }

    @Override
    public void stop() {
        System.out.println("Bmw stop");
    }

    public void foo() {

    }
}
