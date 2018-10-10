package fletz.components;

import fletz.domain.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
public class PersonHandler {

    @Autowired
    private List<Person> personsDummy;

    public Mono<ServerResponse> findOnePerson(ServerRequest request) {
        String id = request.pathVariable("id");
        Optional<Person> p = personsDummy
                .stream()
                .filter(person -> person.getId().equalsIgnoreCase(id))
                .findAny();
        return p.isPresent() ?
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromObject(p.get())) :
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.empty());
    }
}
