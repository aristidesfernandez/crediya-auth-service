package co.com.powerup.r2dbc;

import co.com.powerup.model.usuario.User;
import co.com.powerup.model.usuario.gateways.UserRepository;
import co.com.powerup.r2dbc.entity.UserEntity;
import co.com.powerup.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Repository
public class UserReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        User,
        UserEntity,
        String,
        UserReactiveRepository
> implements UserRepository {
    public UserReactiveRepositoryAdapter(UserReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    @Override
    public Mono<User> save(User user) {
        return super.save(user);
    }
    @Override
    public Flux<User> findAll() {
        return super.findAll();
    }

    @Override
    public Mono<User> findById(String id) {
        return super.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }
}
