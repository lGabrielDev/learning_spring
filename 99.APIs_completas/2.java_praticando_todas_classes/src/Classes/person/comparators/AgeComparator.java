package Classes.person.comparators;
import java.util.Comparator;
import Classes.person.Person;

public class AgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}