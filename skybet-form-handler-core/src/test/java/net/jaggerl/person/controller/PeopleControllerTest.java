package net.jaggerl.person.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Matchers.any;
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

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testThatCallingPostPeopleReturnsOkStatus() throws Exception {
        mockMvc.perform(post(PEOPLE_URI)).andExpect(status().isOk());
    }

    @Test
    public void testThatCallingPostPeopleInteractsWithPeopleService() throws Exception {
        // Act
        mockMvc.perform(post(PEOPLE_URI));

        // Assert
        verify(peopleServiceMock).savePeople(any());
    }
}
