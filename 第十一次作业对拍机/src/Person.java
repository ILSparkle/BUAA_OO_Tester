import java.util.Random;

public class Person {
    private final static Random random = new Random();
    private final int id;
    private final String name;
    private final int age;

    public Person() {
        id = random.nextInt();
        name = "QwQ";
        age = random.nextInt(200);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public String ap() {
        return "ap " + id + " " + name + " " + age;
    }
}
