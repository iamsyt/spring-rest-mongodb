package spring.rest.mongodb.controller

import groovy.util.logging.Slf4j

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import spring.rest.mongodb.domain.Person
import spring.rest.mongodb.models.rest.RestPerson
import spring.rest.mongodb.service.PersonService

@RestController
@RequestMapping(value ="/person")
@Slf4j
class PersonController {
	
	@Autowired
	PersonService personService

	@RequestMapping(method = RequestMethod.GET)
	List<Person> getPersonName(@RequestParam(value = "lastName") String lastName) {
		personService.findByLastName(lastName)
	}

	@RequestMapping(method = RequestMethod.POST)
	String createPerson(@RequestBody RestPerson person){
		personService.createPerson(person)
	}
}
