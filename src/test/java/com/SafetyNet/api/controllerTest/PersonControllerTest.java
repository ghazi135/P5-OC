package com.SafetyNet.api.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.SafetyNet.api.controller.PersonController;
import com.SafetyNet.api.model.Person;
import com.SafetyNet.api.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


    @WebMvcTest(PersonController.class)
    @RunWith(SpringJUnit4ClassRunner.class)
    public class PersonControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        @Autowired
        private PersonService personService ;


        @Test
        public void showAllPersons() throws Exception {
            Person person = new Person();
            List<Person> listPerson = new ArrayList<Person>();
            person.setAddress("15 rue colonel dumont");
            person.setFirstName("ghazi");
            person.setLastName("bouzazi");
            person.setEmail("gbouzazi@gmail.com");
            person.setCity("grenoble");
            person.setZip(38000);
            person.setPhone("0782427444");

            listPerson.add(person);


            when(personService.findAll()).thenReturn(listPerson);

            // ACT
            MvcResult mvcResult = mockMvc.perform(get("/person")).andDo(print()).andReturn();
            int status = mvcResult.getResponse().getStatus();

            // ASSERT
            assertEquals(status, 200);
            verify(personService, times(1)).findAll();
            
        }

        @Test
        public void showPersonById() throws Exception {

            Person person = new Person();
            person.setAddress("15 rue colonel dumont");
            person.setFirstName("ghazi");
            person.setLastName("bouzazi");
            person.setEmail("gbouzazi@gmail.com");
            person.setCity("grenoble");
            person.setZip(38000);
            person.setPhone("0782427444");


            when(personService.findById(any(String.class))).thenReturn(person);

            MvcResult mvcResult = mockMvc.perform(get("/person/GhaziBouzazi")).andDo(print()).andReturn();
            int status = mvcResult.getResponse().getStatus();

            assertEquals(status, 200);
            verify(personService, times(1)).findById(any(String.class));
        }

        @Test
        public void addPerson() throws Exception {

            Person person = new Person();
            person.setAddress("15 rue colonel dumont");
            person.setFirstName("ghazi");
            person.setLastName("bouzazi");
            person.setEmail("gbouzazi@gmail.com");
            person.setCity("grenoble");
            person.setZip(38000);
            person.setPhone("0782427444");

            List<Person> listPerson = new ArrayList<Person>();
            listPerson.add(person);

            when(personService.save(any(Person.class))).thenReturn(listPerson);

            MvcResult mvcResult = mockMvc
                    .perform(post("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\":\"ZZZZ\"}"))
                    .andDo(print()).andReturn();
            int status = mvcResult.getResponse().getStatus();

            assertEquals(status, 200);
            verify(personService, times(1)).save(any(Person.class));
        }

        @Test
        public void updatePerson() throws Exception {

            Person person = new Person();
            person.setAddress("15 rue colonel dumont");
            person.setFirstName("ghazi");
            person.setLastName("bouzazi");
            person.setEmail("gbouzazi@gmail.com");
            person.setCity("grenoble");
            person.setZip(38000);
            person.setPhone("0782427444");
            when(personService.update(any(String.class), any(Person.class))).thenReturn(person);

            // ACT
            MvcResult mvcResult = mockMvc.perform(
                    put("/person/GhaziBouzazi").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\":\"ZZZZ\"}"))
                                         .andDo(print()).andReturn();
            int status = mvcResult.getResponse().getStatus();

            // ASSERT
            assertEquals(status, 200);
            verify(personService, times(1)).update(any(String.class), (any(Person.class)));
        }

        @Test
        public void deletePerson() throws Exception {

            MvcResult mvcResult = mockMvc.perform(delete("/person/Person")).andDo(print()).andReturn();
            int status = mvcResult.getResponse().getStatus();

            assertEquals(status, 200);
            verify(personService, times(1)).deleteById(any(String.class));
        }
}
