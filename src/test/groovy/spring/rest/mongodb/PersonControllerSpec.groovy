package spring.rest.mongodb

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spring.rest.mongodb.controller.PersonController
import spring.rest.mongodb.domain.Person
import spring.rest.mongodb.service.PersonService

import static org.hamcrest.Matchers.hasSize
import static org.hamcrest.Matchers.is
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class PersonControllerSpec extends Specification {

    MockMvc mockMvc

    PersonService personService

    PersonController personController

    void setup() {
        personService = Mock(PersonService)

        personController = new PersonController()
        personController.personService = personService
        mockMvc = MockMvcBuilders.standaloneSetup(personController)
                .build()

    }

    void cleanup() {

    }

    def "get person last name"() {
        when:
        ResultActions resultActions = mockMvc.perform(get("/person?lastName=spock"))
        then:
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(TestUtils.APPLICATION_UTF_8))
                .andExpect(jsonPath('$', hasSize(1)))
                .andExpect(jsonPath('$[0].id', is('spockId')))
                .andExpect(jsonPath('$[0].firstName', is('test')))
                .andExpect(jsonPath('$[0].lastName', is('spock')))


        1 * personService.findByLastName('spock') >> [new Person(id: "spockId", firstName: "test", lastName: 'spock')]
    }

    def "create Person"() {
        when:
        ResultActions resultActions = mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"Rohit Raj\",\"lastName\": \"Thirumurthy\"}"))

        then:
        resultActions.andExpect(status().isCreated())
                .andExpect(content().contentType(TestUtils.APPLICATION_UTF_8))
                .andExpect(jsonPath('$.id', is('spockId')))

        1 * personService.createPerson(_) >> new Person(id: "spockId", firstName: "test", lastName: 'spock')
    }
}
