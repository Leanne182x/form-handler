package net.jaggerl.person.io;

import net.jaggerl.person.model.Person;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class PersonCsvFileStore implements PersonStore {

    private static final String FILENAME = "personStore.csv"; // TODO-LJ this would usually be defined from a property file

    private final FileWriter fileWriter;

    public PersonCsvFileStore() throws IOException {
        fileWriter = new FileWriter(FILENAME, true);
    }

    public PersonCsvFileStore(final FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void savePerson(final Person person) {
        try {
            fileWriter.append(person.toString());
        } catch (IOException e) {
            e.printStackTrace(); // TODO-LJ implement logging
        }
    }
}
