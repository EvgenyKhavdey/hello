package service;

public class OpelServiceImpl implements CarService{
    @Override
    public void start() {
        System.out.println("Opel start");
    }

    @Override
    public void stop() {
        System.out.println("Opel stop");
    }
}
