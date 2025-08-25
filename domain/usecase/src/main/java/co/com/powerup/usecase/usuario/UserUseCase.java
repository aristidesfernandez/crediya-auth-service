package co.com.powerup.usecase.usuario;

import java.math.BigDecimal;

import co.com.powerup.model.usuario.User;
import co.com.powerup.model.usuario.gateways.UserRepository;
import co.com.powerup.usecase.usuario.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

    public Mono<User> saveUser(User user) throws BusinessException {

        BigDecimal salarioBase = user.getSalarioBase();

        if (salarioBase == null || salarioBase.compareTo(BigDecimal.valueOf(15_000_000)) > 0) {
            throw new BusinessException("El salario no puede superar 15M");
        }
        String email = user.getCorreoElectronico();
        if (email == null || email.isBlank() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new BusinessException("Email inválido");
        }
        String nombres = user.getNombres();
        if (nombres == null || nombres.isBlank()) {
            throw new BusinessException("Nombres inválido");
        }
        String apellidos = user.getApellidos();
        if  (apellidos == null || apellidos.isBlank())  {
            throw new BusinessException("Apellidos inválido");
        }
        return userRepository.save(user);
    }

    public Mono<User> updateUser(User user) {
        return userRepository.save(user);
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id);
    }
    
}
