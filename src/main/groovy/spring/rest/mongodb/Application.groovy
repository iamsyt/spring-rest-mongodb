package spring.rest.mongodb

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ImportResource


@EnableAutoConfiguration
@ImportResource("classpath:resources.xml")
class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
