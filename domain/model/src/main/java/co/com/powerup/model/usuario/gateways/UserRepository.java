package co.com.powerup.model.usuario.gateways;

import co.com.powerup.model.usuario.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> save(User user);

    Flux<User> findAll();

    Mono<User> findById(String id);

    Mono<Void> deleteById(String id);

}
