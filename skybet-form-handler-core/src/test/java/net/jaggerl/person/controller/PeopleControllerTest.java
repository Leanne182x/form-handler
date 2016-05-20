package net.jaggerl.person.controller;

import net.jaggerl.person.TestPeople;
import net.jaggerl.person.model.PersonDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class PeopleControllerTest {

    private static final String PEOPLE_URI = "/people";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PeopleService peopleServiceMock;

    @Captor
    private ArgumentCaptor<ArrayList<PersonDto>> peopleArgCaptor;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testThatCallingPostPeopleReturnsOkStatus() throws Exception {
        // Arrange
        final String jsonRequestBody = getJsonStringForDefaultTestPerson();

        // Act/Assert
        mockMvc.perform(post(PEOPLE_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testThatCallingPostPeopleSendsTheCorrectPersonObjectToTheService() throws Exception {
        // Arrange
        final String jsonRequestBody = getJsonStringForDefaultTestPerson();

        // Act
        mockMvc.perform(post(PEOPLE_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody));

        // Assert
        verify(peopleServiceMock).savePeople(peopleArgCaptor.capture());
        PersonDto firstPerson = peopleArgCaptor.getValue().stream().findFirst().get();
        assertThat(firstPerson.getFirstname(), is(TestPeople.DEFAULT_PERSON_FIRST_NAME));
        assertThat(firstPerson.getSurname(), is(TestPeople.DEFAULT_PERSON_SURNAME));
    }

    private String getJsonStringForDefaultTestPerson() {
        return "[{\"firstname\":\"" + TestPeople.DEFAULT_PERSON_FIRST_NAME + "\",\"surname\":\"" + TestPeople.DEFAULT_PERSON_SURNAME +"\"}]";
    }
}
