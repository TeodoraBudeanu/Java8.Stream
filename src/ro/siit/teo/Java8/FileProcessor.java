package ro.siit.teo.Java8;

import ro.siit.teo.Java8.Exceptions.NameValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FileProcessor {

    private PersonsList persons = new PersonsList();

    public void processInput(String inputFile, int month, String outputFile) throws ParseException, IOException {
        readPersonsFromFile(inputFile);
        writeToFile(month, outputFile);
    }

    private void readPersonsFromFile(String inputFile) throws ParseException {
        String csvFile = inputFile;
        String line;
        int numberOfColumns = 3;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                String[] tokens = line.split(",");
                if (tokens.length == numberOfColumns) {
                    Person p = new Person(tokens[0], tokens[1], new SimpleDateFormat("dd/MM/yyyy").parse(tokens[2]));
                    persons.add(p);
                } else {
                    System.out.println("Line '" + line + "' is not formatted correctly");
                }
            }
        } catch (IOException | NameValidationException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    private void writeToFile(int month, String outputFile) throws IOException {
        List<String> lines = persons.selectPersons(month);
        Path file = Paths.get(outputFile);
        Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
    }


}
