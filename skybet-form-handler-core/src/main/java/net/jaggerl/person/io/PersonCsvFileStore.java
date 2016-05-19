package net.jaggerl.person.io;

import net.jaggerl.person.model.Person;

import java.io.FileWriter;
import java.io.IOException;

public class PersonCsvFileStore implements PersonFileStore {

    private final FileWriter fileWriter;

    public PersonCsvFileStore(final FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void savePersonToFile(final Person person) {
        try {
            fileWriter.append(person.toString());
        } catch (IOException e) {
            e.printStackTrace(); // TODO-LJ implement logging
        }
    }
}
