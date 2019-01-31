import org.junit.Before;
import org.junit.Test;
import ro.siit.teo.Java8.Exceptions.NameValidationException;
import ro.siit.teo.Java8.Person;
import ro.siit.teo.Java8.PersonsList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PersonsListTest {

    private Person p1;
    private Person p2;
    private Person p3;
    private PersonsList persons;


    @Before
    public void setup() throws ParseException, NameValidationException {
        p1 = new Person("Mihai", "Marin", new SimpleDateFormat("dd/MM/yyyy").parse("02/05/1992"));
        p2 = new Person("Ana", "Pinzaru", new SimpleDateFormat("dd/MM/yyyy").parse("06/05/1998"));
        p3 = new Person("Mircea", "Bursuc", new SimpleDateFormat("dd/MM/yyyy").parse("06/03/1990"));
        persons = new PersonsList();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

    }


    @Test
    public void whenPersonsAreAddedToPersonsList_GetAllReturnsThem() {
        List<Person> all = persons.getAll();

        assertThat(all, notNullValue());
        assertThat(all.size(), is(3));
        assertThat(new Person[]{p1, p2, p3}, is(all.toArray()));
    }

    @Test
    public void whenListAndMonthAreGiven_FilteredAndSortedListIsReturned() {
    List<Person> filteredList = persons.filterByMonth(5);
        assertThat(filteredList, notNullValue());
        assertThat(filteredList.size(), is(2));
        assertThat(new Person[]{p2, p1}, is(filteredList.toArray()));
    }

    @Test
    public void whenListOfPersonsAndMonthAreGiven_FilteredAndSortedListOfStringsContainingFirstNameAndLastNameIsReturned(){
        List<String> filteredList = persons.selectPersons(5);
        assertThat(filteredList, notNullValue());
        assertThat(filteredList.size(), is(2));
        assertThat("[Ana Pinzaru, Mihai Marin]", is(filteredList.toString()));
    }
}
