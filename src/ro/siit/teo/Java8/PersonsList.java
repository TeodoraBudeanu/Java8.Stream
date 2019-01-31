package ro.siit.teo.Java8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsList {

    private List<Person> persons = new ArrayList<>();

    public void add(Person p) {
        persons.add(p);
    }

    public List<Person> filterByMonth(int month) {
        List<Person> newList = persons.stream()
                .filter(p -> p.getDateOfBirth().getMonthValue() == month)
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
        return newList;
    }

    public List<String> selectPersons(int month) {
        List<String> lines = new ArrayList<>();
        List<Person> newList = filterByMonth(month);
        for (Person p : newList) {
            lines.add(p.getFirstName() + " " + p.getLastName());
        }
        return lines;
    }

    public List<Person> getAll(){
        return persons;
    }

    public int size() {
        return persons.size();
    }
}
