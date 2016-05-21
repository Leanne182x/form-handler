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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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
        final String jsonRequestBody = getJsonListStringForDefaultTestPerson();

        // Act/Assert
        mockMvc.perform(post(PEOPLE_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testThatCallingPostPeopleSendsTheCorrectPersonObjectToTheService() throws Exception {
        // Arrange
        final String jsonRequestBody = getJsonListStringForDefaultTestPerson();

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

    @Test
    public void testThatCallingGetPeopleReturnsJsonResponse() throws Exception {
        // Arrange
        final List<PersonDto> people = Collections.singletonList(TestPeople.getDefaultPersonDto());
        final String expectedJsonResponse = getJsonListStringForDefaultTestPerson();

        when(peopleServiceMock.getPeople()).thenReturn(people);

        // Act
        final MvcResult mvcResult = mockMvc.perform(get(PEOPLE_URI))
                                            .andExpect(status().isOk())
                                            .andReturn();

        // Assert
        verify(peopleServiceMock).getPeople();
        assertThat(mvcResult.getResponse().getContentAsString(), is(expectedJsonResponse));
    }

    @Test
    public void testThatUpdatePersonReturnsOkStatus() throws Exception {
        // Arrange
        final String jsonRequestBody = getJsonStringForDefaultTestPerson();

        // Act/Assert
        mockMvc.perform(put(PEOPLE_URI + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testThatCallingPutPeopleSendsTheCorrectPersonObjectToTheService() throws Exception {
        // Arrange
        final String jsonRequestBody = getJsonStringForDefaultTestPerson();
        final ArgumentCaptor<PersonDto> personDtoArgCaptor = ArgumentCaptor.forClass(PersonDto.class);

        // Act
        mockMvc.perform(put(PEOPLE_URI + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody));

        // Assert
        verify(peopleServiceMock).updatePerson(personDtoArgCaptor.capture());
        final PersonDto person = personDtoArgCaptor.getValue();
        assertThat(person.getFirstname(), is(TestPeople.DEFAULT_PERSON_FIRST_NAME));
        assertThat(person.getSurname(), is(TestPeople.DEFAULT_PERSON_SURNAME));
    }

    private String getJsonListStringForDefaultTestPerson() {
        return "[" + getJsonStringForDefaultTestPerson() + "]";
    }

    private String getJsonStringForDefaultTestPerson() {
        return "{\"firstname\":\"" + TestPeople.DEFAULT_PERSON_FIRST_NAME + "\",\"surname\":\"" + TestPeople.DEFAULT_PERSON_SURNAME +"\"}";
    }
}
