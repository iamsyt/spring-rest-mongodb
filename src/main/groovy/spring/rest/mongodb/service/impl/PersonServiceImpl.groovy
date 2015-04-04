package spring.rest.mongodb.service.impl

import groovy.util.logging.Slf4j

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import spring.rest.mongodb.domain.Person
import spring.rest.mongodb.models.rest.RestPerson
import spring.rest.mongodb.repositories.PersonRepository
import spring.rest.mongodb.service.PersonService

@Component("personService")
@Slf4j
class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository

	@Override
	public List<Person> findByLastName(String lastName) {
		return personRepository.findByLastName(lastName)
	}

	@Override
	String createPerson(RestPerson restPerson) {
		Person person = new Person(
				firstName: restPerson.firstName,
				lastName: restPerson.lastName
		)

		person = personRepository.save(person)

		return person.id


	}
}
