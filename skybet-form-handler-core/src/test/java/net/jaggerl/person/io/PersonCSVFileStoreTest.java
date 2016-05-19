package net.jaggerl.person.io;

import net.jaggerl.person.TestPeople;
import net.jaggerl.person.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;

public class PersonCSVFileStoreTest {

    private PersonFileStore personCSVFileStore;
    private FileWriter fileWriter;

    @Before
    public void setUp() {
        fileWriter = Mockito.mock(FileWriter.class);
        personCSVFileStore = new PersonCsvFileStore(fileWriter);
    }

    @Test
    public void testAPersonCanBeSavedToACsvFile() throws IOException {
        // Arrange
        final Person person = TestPeople.aDefaultPerson().build();
        final ArgumentCaptor<String> fileContentCaptor = ArgumentCaptor.forClass(String.class);
        final String expectedFileString = TestPeople.DEFAULT_PERSON_FIRST_NAME + ", " + TestPeople.DEFAULT_PERSON_SURNAME;

        // Act
        personCSVFileStore.savePersonToFile(person);

        // Assert
        verify(fileWriter).append(fileContentCaptor.capture());
        assertThat(fileContentCaptor.getValue(), is(expectedFileString));
    }
}
