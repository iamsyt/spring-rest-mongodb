package spring.rest.mongodb.models.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.validator.constraints.NotBlank

@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
class RestPerson implements Serializable {

    @NotBlank
    String firstName

    @NotBlank
    String lastName
}
