import java.util.ArrayList;
import java.util.Random;

public class Generator {
    private final DataPool dataPool;

    private final Strategy strategy;

    private final ArrayList<Person> toAdd;

    private final ArrayList<Person> added = new ArrayList<>();

    private final ArrayList<Person> notAdd;

    private final Random random = new Random();

    public Generator(DataPool dataPool, Strategy strategy) {
        this.dataPool = dataPool;
        this.strategy = strategy;
        this.toAdd = dataPool.toAddPeople;
        this.notAdd = dataPool.notAddPeople;
    }

    public Person add() {
        if (toAdd.size() == 0) {
            return new Person();
        }
        return toAdd.get(random.nextInt(toAdd.size()));
    }

    public Person added() {
        if (added.size() == 0) {
            return add();
        } else {
            return added.get(random.nextInt(added.size()));
        }
    }

    public Person notAdd() {
        if (random.nextInt(100) > 60) {
            return add();
        }
        return notAdd.get(random.nextInt(notAdd.size()));
    }

    public Person randPerson() {
        if (random.nextInt() > 90) {
            return added();
        } else {
            return notAdd();
        }
    }

    public String ap() {
        Person person = add();
        added.add(person);
        toAdd.remove(person);
        return person.ap();
    }

    public String ar() {
        int value = 1 + random.nextInt(100);
        return "ar " + randPerson() + " " + randPerson() + " " + value;
    }

    public String qv() {
        return "qv " + randPerson() + " " + randPerson();
    }

    public String qci() {
        return "qci " + randPerson() + " " + randPerson();
    }

    public String qbs() {
        return "qbs";
    }

    public String qts() {
        return "qts";
    }

    public String ag() {
        return "ag " + dataPool.groups.get(random.nextInt(5));
    }

    public String atg() {
        return "atg " + randPerson() + " " + dataPool.groups.get(random.nextInt(5));
    }

    public String dfg() {
        return "dfg " + randPerson() + " " + dataPool.groups.get(random.nextInt(5));
    }

    public String qgvs() {
        return "qgvs " + dataPool.groups.get(random.nextInt(5));
    }

    public String qgav() {
        return "qgav " + dataPool.groups.get(random.nextInt(5));
    }

    public String mr() {
        int value = random.nextInt(100);
        if (random.nextInt(100) < 80) {
            value *= -1;
        }
        return "mr " + randPerson() + " " + randPerson() + " " + value;
    }

    public String qba() {
        return "qba " + randPerson();
    }

    public String qcs() {
        return "qcs";
    }

    public String am() {
        int value = random.nextInt(100);
        if (random.nextBoolean()) {
            value *= -1;
        }
        if (random.nextBoolean()) {
            return "am " + dataPool.messages.get(random.nextInt(dataPool.messages.size())) + " " + value + " " + 0 + " " + added() + " " + added();
        } else {
            return "am " + dataPool.messages.get(random.nextInt(dataPool.messages.size())) + " " + value + " " + 1 + " " + added() + " "
            + dataPool.groups.get(random.nextInt(5));
        }
    }

    public String sm() {
        if (random.nextInt(100) < 95) {
            return "sm " + dataPool.messages.get(random.nextInt(dataPool.messages.size())).toString();
        } else {
            return "sm " + String.valueOf(random.nextInt());
        }
    }

    public String qsv() {
        return "qsv " + randPerson();
    }

    public String qrm() {
        return "qrm " + randPerson();
    }
}
