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
            } else if (i < 105) {
                System.out.println(generator.sei());
            } else {
                    int num = random.nextInt(strategy.valueSum);
                    if (num < strategy.ap) {
                        System.out.println(generator.ap());
                    } else if (num < strategy.ar) {
                        System.out.println(generator.ar());
                    } else if (num < strategy.qv) {
                        System.out.println(generator.qv());
                    } else if (num < strategy.qci) {
                        System.out.println(generator.qci());
                    } else if (num < strategy.qbs) {
                        System.out.println(generator.qbs());
                    } else if (num < strategy.qts) {
                        System.out.println(generator.qts());
                    } else if (num < strategy.ag) {
                        System.out.println(generator.ag());
                    } else if (num < strategy.atg) {
                        System.out.println(generator.atg());
                    } else if (num < strategy.dfg) {
                        System.out.println(generator.dfg());
                    } else if (num < strategy.qgvs) {
                        System.out.println(generator.qgvs());
                    } else if (num < strategy.qgav) {
                        System.out.println(generator.qgav());
                    } else if (num < strategy.mr) {
                        System.out.println(generator.mr());
                    } else if (num < strategy.qba) {
                        System.out.println(generator.qba());
                    } else if (num < strategy.qcs) {
                        System.out.println(generator.qcs());
                    } else if (num < strategy.am) {
                        System.out.println(generator.am());
                    } else if (num < strategy.sm) {
                        System.out.println(generator.sm());
                    } else if (num < strategy.qsv) {
                        System.out.println(generator.qsv());
                    } else if (num < strategy.qrm) {
                        System.out.println(generator.qrm());
                    } else if (num < strategy.arem) {
                        System.out.println(generator.arem());
                    } else if (num < strategy.anm) {
                        System.out.println(generator.anm());
                    } else if (num < strategy.cn) {
                        System.out.println(generator.cn());
                    } else if (num < strategy.aem) {
                        System.out.println(generator.aem());
                    } else if (num < strategy.sei) {
                        System.out.println(generator.sei());
                    } else if (num < strategy.qp) {
                        System.out.println(generator.qp());
                    } else if (num < strategy.dce) {
                        System.out.println(generator.dce());
                    } else if (num < strategy.qm) {
                        System.out.println(generator.qm());
                    } else if (num < strategy.qlm) {
                        System.out.println(generator.qlm());
                    }
                }
            }
        }
    }
