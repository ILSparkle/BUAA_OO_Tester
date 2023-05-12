import java.util.ArrayList;
import java.util.Random;

public class Strategy {
    public final int oderNum;
    public final int peopleNum;

    public final int ap;

    public final int ar;

    public final int qv;

    public final int qci;

    public final int qbs;

    public final int qts;

    public final int ag;

    public final int atg;

    public final int dfg;

    public final int qgvs;

    public final int qgav;

    public final int mr;

    public final int qba;

    public final int qcs;

    public final int am;

    public final int sm;

    public final int qsv;

    public final int qrm;

    public final int arem;

    public final int anm;

    public final int cn;

    public final int aem;

    public final int sei;

    public final int qp;

    public final int dce;

    public final int qm;

    public final int qlm;

    public final int valueSum;

    public Strategy() {
        Random random = new Random();
        oderNum = 750 + random.nextInt(250);
        peopleNum = 150 + random.nextInt(200);
        ap = 10;
        ar = ap + 10;
        qv = ar + 10;
        qci = qv + 10;
        qbs = qci + 10;
        qts = qbs + 10;
        ag = qts + 1;
        atg = ag + 10;
        dfg = atg + 10;
        qgvs = dfg + 10;
        qgav = qgvs + 5;
        mr = qgav + 30;
        qba = mr + 10;
        qcs = qba + 10;
        am = qcs + 5;
        sm = am + 40;
        qsv = sm + 10;
        qrm = qsv + 10;
        arem = qrm + 30;
        anm = arem + 10;
        cn = anm + 5;
        aem = cn + 50;
        sei = aem + 3;
        qp = sei + 10;
        dce = qp + 3;
        qm = dce + 5;
        qlm = qm + 10;
        valueSum = qlm;
    }
}
