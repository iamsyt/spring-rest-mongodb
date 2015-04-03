package spring.rest.mongodb.service

import spring.rest.mongodb.domain.Person



public interface PersonService {
	
	List<Person> findByLastName(String lastName) 

}
