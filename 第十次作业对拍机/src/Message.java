import java.util.ArrayList;
import java.util.Random;

public class Message {
    private final int id;
    private int socialValue;
    private final int type;
    private final String p1;
    private final String  p2;
    private final String group;
    private final static Random random = new Random();

    public Message(ArrayList<Person> people, ArrayList<Person> other, ArrayList<Group> groups) {
        this.type = random.nextInt(2);
        this.socialValue = 1 + random.nextInt(1000);
        if (random.nextInt(100) < 70) {
            this.socialValue *= -1;
        }
        this.id = random.nextInt();
        if (random.nextInt(100) < 90) {
            this.p1 = people.get(random.nextInt(people.size())).toString();
        } else {
            this.p1 = other.get(random.nextInt(other.size())).toString();
        }
        if (random.nextInt(100) < 90) {
            this.p2 = people.get(random.nextInt(people.size())).toString();
        } else {
            this.p2 = other.get(random.nextInt(other.size())).toString();
        }
        this.group = groups.get(random.nextInt(groups.size())).toString();
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public String am() {
        if (type == 0) {
            return "am " + id + " " + socialValue + " " + type + " "
                    + p1 + " " + p2;
        } else {
            return "am " + id + " " + socialValue + " " + type + " "
                    + p1 + " " + group;
        }
    }
}
