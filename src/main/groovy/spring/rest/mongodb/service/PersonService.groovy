package spring.rest.mongodb.service

import spring.rest.mongodb.domain.Person
import spring.rest.mongodb.models.rest.request.RestPerson

public interface PersonService {

    List<Person> findByLastName(String lastName)

    Person createPerson(RestPerson restPerson)

}
