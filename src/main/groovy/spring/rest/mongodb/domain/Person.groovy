package spring.rest.mongodb.domain

import org.springframework.data.annotation.Id
import org.springframework.stereotype.Component

@Component
public class Person {

    @Id
    String id

    String firstName
    String lastName
}