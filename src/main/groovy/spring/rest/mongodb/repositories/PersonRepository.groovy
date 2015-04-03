package spring.rest.mongodb.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

import spring.rest.mongodb.domain.Person

@Component
public interface PersonRepository extends MongoRepository<Person, Long> {

	List<Person> findByLastName(String lastName)
}
