import java.util.ArrayList;
import java.util.Random;

public class Generator {
    private final static Random random = new Random();

    private final static int bound = 1 << 30;
    public static String gen(Strategy strategy, ArrayList<Integer> ids) {
        int randInt = random.nextInt(100);
        int type = strategy.getAll();
        if (type == 0) {
            return genData(ids, strategy, 40, 70, 77, 84, 91);
        } else if (type == 1) {
            return genData(ids, strategy, 0, 30, 50, 70, 90);
        } else if (type == 2) {
            return genData(ids, strategy, 70, 70, 70, 70, 70);
        } else if (type == 3) {
            return genData(ids, strategy, 35, 70, 0, 0, 100);
        } else if (type == 4) {
            return genData(ids, strategy, 35, 70, 0, 100, 0);
        } else if (type == 5) {
            return genData(ids, strategy, 30, 30, 50, 70, 90);
        } else if (type == 6) {
            return genData(ids, strategy, 30, 50, 0, 0, 100);
        } else {
            return genData(ids, strategy, 40, 60, 0 , 0, 90);
        }
    }

    public static String genData(ArrayList<Integer> ids, Strategy strategy,
                          int ap, int ar, int qv, int qci, int qbs) {
        int randInt = random.nextInt(100);
        if (randInt < ap) {
            return apGen();
        } else if (randInt < ar) {
            return arGen(ids, strategy.getAr());
        } else if (randInt < qv) {
            return qvGen(ids, strategy.getQv(), 1);
        } else if (randInt < qci) {
            return qvGen(ids, strategy.getQci(), 0);
        } else if (randInt < qbs) {
            return "qbs";
        } else {
            return "qts";
        }
    }

    public static String apGen() {
        return "ap " + random.nextInt(bound) + " hhh 10";
    }

    public static String arGen(ArrayList<Integer> ids, int strategy) { //可能随机生成，可能按已有的生成
        int size = ids.size();
        if (size == 0) {
            strategy = 1;
        }
        if (strategy == 0) {
            if (random.nextInt(100) < 90) {
                return "ar " + ids.get(random.nextInt(size)) + " "
                        + ids.get(random.nextInt(size)) + " " + (random.nextInt(100) + 1);
            } else {
                return "ar " + random.nextInt(bound) + " "
                        + random.nextInt(bound) + " " + (random.nextInt(100) + 1);
            }
        } else if (strategy == 1) {
            if (random.nextInt(100) < 70) {
                return "ar " + random.nextInt(bound) + " "
                        + random.nextInt(bound) + " " + (random.nextInt(100) + 1);
            } else {
                int id = random.nextInt(bound);
                return "ar " + id + " "
                        + id + " " + (random.nextInt(100) + 1);
            }
        } else {
            if (random.nextInt(100) < 70) {
                return "ar " + ids.get(random.nextInt(size)) + " "
                        + ids.get(random.nextInt(size)) + " " + (random.nextInt(100) + 1);
            } else {
                int id = ids.get(random.nextInt(size));
                return "ar " + id + " " + id + " " + (random.nextInt(100) + 1);
            }
        }
    }

    public static String qvGen(ArrayList<Integer> ids, int strategy, int type) {
        String out;
        if (type == 1) {
            out = "qv ";
        } else {
            out = "qci ";
        }
        int size = ids.size();
        if (size == 0) {
            strategy = 1;
        }
        if (strategy == 0) {
            if (random.nextInt(100) < 90) {
                return out + ids.get(random.nextInt(size)) + " " + ids.get(random.nextInt(size));
            } else {
                return out + random.nextInt(bound) + " " + random.nextInt(bound);
            }
        } else if (strategy == 1) {
            if (random.nextInt(100) < 70) {
                return out + random.nextInt(bound) + " " + random.nextInt(bound);
            } else {
                int id = random.nextInt(bound);
                return out + id + " " + id;
            }
        } else {
            if (random.nextInt(100) < 70) {
                return out + ids.get(random.nextInt(size)) + " " + ids.get(random.nextInt(size));
            } else {
                int id = ids.get(random.nextInt(size));
                return out + id + " " + id;
            }
        }
    }
}
