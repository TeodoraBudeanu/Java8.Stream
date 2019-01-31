import org.junit.Before;
import org.junit.Test;
import ro.siit.teo.Java8.Exceptions.MonthValidationException;
import ro.siit.teo.Java8.FileProcessor;
import ro.siit.teo.Java8.PersonsList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FileProcessorTest {

    private FileProcessor fileProcessor;
    private PersonsList persons;


    @Before
    public void setup() {
        fileProcessor = new FileProcessor();
        persons = new PersonsList();
    }

    @Test(expected = MonthValidationException.class)
    public void whenInvalidMonthIsEntered_ThrowsException() throws ParseException, MonthValidationException, IOException {
        fileProcessor.processInput("./Test/TestResources/input.csv", 15, "./Test/TestResources/output.csv");
    }

    @Test
    public void whenGivenInputFile_ProcessesAndWritesInOutputFile() throws ParseException, IOException, MonthValidationException {
        fileProcessor.processInput("./Test/TestResources/input.csv", 4, "./Test/TestResources/output.csv");
        BufferedReader br = new BufferedReader(new FileReader("./Test/TestResources/output.csv"));
        String line = br.readLine();
        assertThat(line, is("Mihai Marin"));
    }
}
