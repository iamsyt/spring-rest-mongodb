package spring.rest.mongodb.controller

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import spring.rest.mongodb.domain.Person
import spring.rest.mongodb.models.rest.request.RestPerson
import spring.rest.mongodb.models.rest.response.CreatedResponse
import spring.rest.mongodb.service.PersonService

@RestController
@RequestMapping(value = "/person")
@Slf4j
class PersonController {

    @Autowired
    PersonService personService

    @RequestMapping(method = RequestMethod.GET)
    List<Person> getPersonByLastName(@RequestParam(value = "lastName") String lastName) {
        personService.findByLastName(lastName)
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    CreatedResponse createPerson(@RequestBody RestPerson restPerson) {

        Person person = personService.createPerson(restPerson)
        return new CreatedResponse(id: person.id)
    }
}
