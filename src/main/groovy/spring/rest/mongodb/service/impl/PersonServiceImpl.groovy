package spring.rest.mongodb.service.impl

import groovy.util.logging.Slf4j

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import spring.rest.mongodb.domain.Person
import spring.rest.mongodb.repositories.PersonRepository
import spring.rest.mongodb.service.PersonService

@Component("personService")
@Slf4j
class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository

	@Override
	public List<Person> findByLastName(String lastName) {
		log.info("Service is autowired and working")
//		return personRepository.findByLastName(lastName)
		return []
	}

}
