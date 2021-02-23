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
