import java.util.Random;

public class Strategy {
    public final int oderNum;
    public final int peopleNum;

    public Strategy() {
        Random random = new Random();
        oderNum = 750 + random.nextInt(250);
        peopleNum = 150 + random.nextInt(200);
    }
}
