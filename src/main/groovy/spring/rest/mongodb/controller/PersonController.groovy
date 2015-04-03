package spring.rest.mongodb.controller

import groovy.util.logging.Slf4j

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import spring.rest.mongodb.service.PersonService

@RestController
@RequestMapping(value ="/person")
@Slf4j
class PersonController {
	
	@Autowired
	PersonService personService

	@RequestMapping(method = RequestMethod.GET)
	String getPersonName() {
		log.info("Controller is working")
		personService.findByLastName("hi")	
	}
}
