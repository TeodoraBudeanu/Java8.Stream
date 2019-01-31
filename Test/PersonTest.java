import org.junit.Test;
import ro.siit.teo.Java8.Exceptions.NameValidationException;
import ro.siit.teo.Java8.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonTest {

    @Test (expected = NameValidationException.class)
    public void whenInvalidNameIsEntered_ExceptionIsThrown() throws ParseException, NameValidationException {
        Person p = new Person("Ana4", "Mihai", new SimpleDateFormat("dd/MM/yyyy").parse("02/05/1992"));
    }
}
