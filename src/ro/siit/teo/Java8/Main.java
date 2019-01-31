package ro.siit.teo.Java8;

import ro.siit.teo.Java8.Exceptions.MonthValidationException;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException, MonthValidationException {

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processInput("./resources/data.csv",5, "./resources/output.csv");

    }
}
