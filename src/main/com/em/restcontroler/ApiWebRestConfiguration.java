package main.com.em.restcontroler;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiWebRestConfiguration {


    @Bean
    public ApiWebRestController apiWebRestController() {
        return new ApiWebRestController();
    }
}
