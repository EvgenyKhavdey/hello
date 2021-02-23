import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Phonebook {
    private String name;
    private long tel;

    public Phonebook(String name, long tel) {
        this.name = name;
        this.tel = tel;
    }

    public Phonebook() {

    }
    public static void book() {
        Phonebook number = new Phonebook("Tramp", 89999999999l);
        Phonebook number1 = new Phonebook("Biden", 89998888888l);
        Phonebook number2 = new Phonebook("Merkel", 89997777777l);
        Phonebook number3 = new Phonebook("Obama", 89996666666l);
        Phonebook number4 = new Phonebook("Johnson", 89995555555l);
        Phonebook number5 = new Phonebook("Macron", 89994444444l);
        Phonebook number6 = new Phonebook("Conte", 89993333333l);
        Phonebook number7 = new Phonebook("Merkel", 89992222222l);
        Phonebook number8 = new Phonebook("Trudeau", 89991111111l);
        Phonebook number9 = new Phonebook("Tramp", 89990000000l);

        LinkedList<Phonebook> list = new LinkedList<>();
        list.add(number);
        list.add(number1);
        list.add(number2);
        list.add(number3);
        list.add(number4);
        list.add(number5);
        list.add(number6);
        list.add(number7);
        list.add(number8);
        list.add(number9);
        list.forEach(System.out::println);
        Iterator<Phonebook> iter = list.iterator();
        Phonebook person = new Phonebook();
        person = list.get(7);
        while (iter.hasNext()) {
            Phonebook str = iter.next();
            if (str.equals(person)) {
            } else {
                iter.remove();
            }
        }
        System.out.println(" ");
        System.out.println(list);

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "name='" + name + '\'' +
                ", tel=" + tel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phonebook phonebook = (Phonebook) o;
        return  Objects.equals(name, phonebook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
