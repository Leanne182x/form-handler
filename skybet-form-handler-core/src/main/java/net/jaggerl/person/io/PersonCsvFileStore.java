package net.jaggerl.person.io;

import net.jaggerl.person.model.Person;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class PersonCsvFileStore implements PersonStore {

    // TODO-LJ this would usually be defined from a property file. Stored in a target directory meaning a new build will wipe it
    private static final String FILENAME = "target/personStore.csv";

    private final BufferedWriter bufferedWriter;

    public PersonCsvFileStore() throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(FILENAME, true));
    }

    public PersonCsvFileStore(final BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void savePerson(final Person person) {
        try {
            bufferedWriter.write(person.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace(); // TODO-LJ implement logging, e.g. log4j/slf4j
        }
    }
}
