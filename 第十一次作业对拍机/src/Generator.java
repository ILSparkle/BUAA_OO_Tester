import java.util.ArrayList;
import java.util.Random;

public class Generator {
    private final DataPool dataPool;

    private final Strategy strategy;

    private final ArrayList<Person> toAdd;

    private final ArrayList<Person> added = new ArrayList<>();

    private final ArrayList<Person> notAdd;

    private final ArrayList<Integer> messId;

    private final ArrayList<Integer> emojiId;

    private final Random random = new Random();

    public int randMess() {
        int res = random.nextInt(40);
        messId.add(res);
        return res;
    }

    public String randStr() {
        String s = "";
        int length = 10 + random.nextInt(90);
        for (int i = 0; i < length; i++) {
            char c = (char)('A' + random.nextInt(60));
            s = s.concat(c + "");
        }
        return s;
    }

    public Generator(DataPool dataPool, Strategy strategy) {
        this.dataPool = dataPool;
        this.strategy = strategy;
        this.toAdd = dataPool.toAddPeople;
        this.emojiId = new ArrayList<>();
        this.messId = new ArrayList<>();
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
        int value = random.nextInt(1000);
        if (random.nextBoolean()) {
            value *= -1;
        }
        if (random.nextBoolean()) {
            return "am " + randMess() + " " + value + " " + 0 + " " + added() + " " + added();
        } else {
            return "am " + randMess() + " " + value + " " + 1 + " " + added() + " "
            + dataPool.groups.get(random.nextInt(5));
        }
    }

    public String sm() {
        if (messId.size() > 0 && random.nextInt(100) < 98) {
            return "sm " + messId.get(random.nextInt(messId.size()));
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

    public String arem() {
        int value = random.nextInt(200);
        if (random.nextBoolean()) {
            return "arem " + randMess() + " " + value + " " + 0 + " " + added() + " " + added();
        } else {
            return "arem " + randMess() + " " + value + " " + 1 + " " + added() + " "
                    + dataPool.groups.get(random.nextInt(5));
        }
    }

    public String anm() {
        String value = randStr();
        if (random.nextBoolean()) {
            return "anm " + randMess() + " " + value + " " + 0 + " " + added() + " " + added();
        } else {
            return "anm " + randMess() + " " + value + " " + 1 + " " + added() + " "
                    + dataPool.groups.get(random.nextInt(5));
        }
    }

    public String cn() {
        return "cn " + randPerson();
    }

    public String aem() {
        int value;
        if (emojiId.size() > 0) {
            if (random.nextInt(100) > 90) {
                value = emojiId.get(random.nextInt(emojiId.size()));
            } else {
                value = random.nextInt(1000);
                if (random.nextBoolean()) {
                    value *= -1;
                }
            }
        } else {
            value = random.nextInt(1000);
            if (random.nextBoolean()) {
                value *= -1;
            }
        }
        if (random.nextBoolean()) {
            return "aem " + randMess() + " " + value + " " + 0 + " " + added() + " " + added();
        } else {
            return "aem " + randMess() + " " + value + " " + 1 + " " + added() + " "
                    + dataPool.groups.get(random.nextInt(5));
        }
    }

    public String sei() {
        int value = random.nextInt(100);
        if (random.nextBoolean()) {
            value *= -1;
        }
        emojiId.add(value);
        return "sei " + value;
    }

    public String qp() {
        return "qp " + randPerson();
    }

    public String dce() {
        int limit = 1 + random.nextInt(5);
        return "dce " + limit;
    }

    public String qm() {
        return "qm " + randPerson();
    }

    public String qlm() {
        return "qlm " + randPerson();
    }
}
