import java.util.ArrayList;

public class DataPool {
    ArrayList<Person> toAddPeople;

    Strategy strategy;

    ArrayList<Person> notAddPeople;

    ArrayList<Group> groups;

    ArrayList<Message> messages;

    public DataPool(Strategy strategy) {
        this.strategy = strategy;
        this.toAddPeople = new ArrayList<>();
        for (int i = 0; i < strategy.peopleNum; i++) {
            toAddPeople.add(new Person());
        }
        this.notAddPeople = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            notAddPeople.add(new Person());
        }
        this.groups = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            groups.add(new Group());
        }
        this.messages = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            messages.add(new Message(toAddPeople, notAddPeople, groups));
        }
    }
}
