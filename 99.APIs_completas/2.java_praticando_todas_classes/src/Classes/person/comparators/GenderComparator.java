package Classes.person.comparators;
import java.util.Comparator;
import Classes.person.Person;

public class GenderComparator implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2) {
        return p2.getGender().getName().compareTo(p1.getGender().getName());
    }
}