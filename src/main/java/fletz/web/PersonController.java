package fletz.web;

import fletz.components.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PersonController {

    @Bean
    public RouterFunction<ServerResponse> route(PersonHandler personHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/person/{id}")
                        .and(RequestPredicates.accept(MediaType.ALL)),
                        personHandler::findOnePerson);
    }
}
