package a;

public class Dog extends Animal{
    public static String name;
    public static int p;

    public Dog(){
        this.name = name;
        this.p = p;
    }

    public static void dogRun(){

            System.out.println("Введите кличку собакии и расстояние, которое она пробежит");
            name = sc.next();
            p = sc.nextInt();
            if (p <= 500) {
                run(name, p);
                dogSail(name);
            } else {
                System.out.println("Собака не может пробежать больше 500 метров");
                dogRun();
            }
    }
    public static void dogSail(String name){
        System.out.println("Введите расстояние, которое " + name + " проплывет");
        p = sc.nextInt();
        if (p <= 10) {
            sail(name, p);
        } else {
            System.out.println("Собака не может проплыть больше 10 метров");
            dogSail(name);
        }

    }

}
