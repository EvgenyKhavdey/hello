package hw2;

public class Main {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mail.ru", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Engineer", "petrov@mail.ru", "892312312", 30000, 45);
        persArray[2] = new Person("Sedorov Semen", "Engineer", "sid@mail.ru", "892312312", 30000, 26);
        persArray[3] = new Person("Romanov Roman", "Engineer", "rromanov@mail.ru", "892312312", 30000, 42);
        persArray[4] = new Person("Borisov Boris", "Engineer", "bb@mail.ru", "892312312", 30000, 37);


        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() >= 40) {
                persArray[i].printPersonInfo();
            }
        }

    }
}