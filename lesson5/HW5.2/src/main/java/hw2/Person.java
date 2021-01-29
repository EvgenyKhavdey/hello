package hw2;

public class Person {
    private String name;
    private String position;
    private String mail;
    private String tel;
    private int income;
    private int age;

    public Person(String name, String position, String mail, String tel, int income, int age) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.tel = tel;
        this.income = income;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public void printPersonInfo() {
        System.out.println("Имя = " + name + ", должность =" + position + ", eMail" + mail + ", телефон =" + tel + ", заработная плата =" + income + ", возраст =" + age);
    }
}



