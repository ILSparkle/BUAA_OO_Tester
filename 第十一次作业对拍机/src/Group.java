import java.util.Random;

public class Group {
    private final int id;

    private final static Random random = new Random();

    public Group() {
        this.id = random.nextInt();
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
