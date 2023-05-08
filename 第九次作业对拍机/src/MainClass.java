import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {
        Strategy strategy = new Strategy();
        int num = strategy.getNum();
        ArrayList<Integer> people = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String out = Generator.gen(strategy, people);
            Pattern pattern = Pattern.compile("ap ([0-9]+)");
            Matcher matcher = pattern.matcher(out);
            if (matcher.find()) {
                people.add(Integer.valueOf(matcher.group(1)));
            }
            System.out.println(out);
        }
    }
}
