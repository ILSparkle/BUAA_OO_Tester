import java.util.Random;

public class Strategy {
    private Random random = new Random();

    private int ap;

    private int ar;

    private int qci;

    private int qv;

    private int all;

    private int num;
    public Strategy() {
        this.ap = random.nextInt(3);
        this.ar = random.nextInt(3);
        this.qci = random.nextInt(3);
        this.qv = random.nextInt(3);
        this.all = random.nextInt(10);
        this.num = 10 + random.nextInt(990);
    }

    public int getNum() {
        return num;
    }

    public int getQv() {
        return qv;
    }

    public int getAp() {
        return ap;
    }

    public int getAll() {
        return all;
    }

    public int getAr() {
        return ar;
    }

    public int getQci() {
        return qci;
    }
}
