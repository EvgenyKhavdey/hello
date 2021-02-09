package hw1;

public class Employee {
     String name;
     String position;
     String mail;
     long tel;
     int income;
     int age;

    public static class EmployeeInfo {
        public static void main (String[] args) {
            Employee employee = new Employee();
            employee.name = "Вася Батарейкин";
            employee.position = "Программист";
            employee.mail = "batareykin@mail.ru";
            employee.tel = 88007524217L;
            employee.income = 100000;
            employee.age = 21;
            System.out.println("Сотрудник имя: " + employee.name + " должность: " + employee.position + " email: " + employee.mail + " телефон: " + employee.tel + " заработная пдата: " + employee.income + " рублей, возраст: " + employee.age);
        }
    }
}

