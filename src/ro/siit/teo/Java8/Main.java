package ro.siit.teo.Java8;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processInput("./resources/data.csv",5, "./resources/output.csv");

    }
}
