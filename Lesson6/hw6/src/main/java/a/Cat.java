package a;

public class Cat extends Animal {

    public Cat(){
        this.name = name;
        this.p = p;
    }
    public static void catRun(){
        System.out.println("Введите кличку кошки и расстояние, которое она пробежит");
        name = sc.next();
        p = sc.nextInt();
        if (p <= 200) {
            run(name, p);
            catSail(name);
        } else {
            System.out.println("Кошка не может пробежать больше 200 метров");
            catRun();
        }
    }

    public static void catSail(String nane){
        System.out.println("Введите  расстояние, которое " + name + " проплывет");
        p = sc.nextInt();
        if (p <= 0) {
            sail(name, p);
        } else {
            System.out.println("Кошка не умеет плавать");
            catSail(name);
        }

    }


}
