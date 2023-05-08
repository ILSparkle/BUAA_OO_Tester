import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Strategy strategy = new Strategy();
        DataPool dataPool = new DataPool(strategy);
        Generator generator = new Generator(dataPool, strategy);
        Random random = new Random();
        for (int i = 0; i < strategy.oderNum; i++) {
            if (i < 5) {
                System.out.println(generator.ag());
            } else if (i < 40) {
                System.out.println(generator.ap());
            } else if (i < 70) {
                if (random.nextInt(10) < 4) {
                    System.out.println(generator.ap());
                } else if (random.nextInt(10) < 7){
                    System.out.println(generator.ar());
                } else {
                    System.out.println(generator.mr());
                }
            } else if (i < 100) {
                System.out.println(generator.atg());
            } else {
                int num = random.nextInt(100);
                if (num < 10) {
                    System.out.println(generator.ap());
                } else if (num < 15) {
                    System.out.println(generator.mr());
                } else if (num < 20) {
                    System.out.println(generator.ar());
                } else if (num < 25) {
                    System.out.println(generator.atg());
                } else if (num < 30) {
                    System.out.println(generator.dfg());
                } else if (num < 35) {
                    System.out.println(generator.am());
                } else if (num < 40) {
                    System.out.println(generator.qba());
                } else if (num < 42) {
                    System.out.println(generator.qv());
                } else if (num < 50) {
                    System.out.println(generator.qgav());
                } else if (num < 60) {
                    System.out.println(generator.qgvs());
                } else if (num < 65) {
                    System.out.println(generator.qcs());
                } else if (num < 70) {
                    System.out.println(generator.qbs());
                } else if (num < 75) {
                    System.out.println(generator.qrm());
                } else if (num < 80) {
                    System.out.println(generator.sm());
                } else if (num < 85) {
                    System.out.println(generator.qci());
                } else if (num < 90) {
                    System.out.println(generator.qts());
                } else if (num < 95) {
                    System.out.println(generator.qsv());
                }
            }
        }
    }
}
