package co.com.powerup.model.usuario;
import lombok.*;

import java.math.BigDecimal;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String id;
    private String nombres;
    private String apellidos;
    private String correoElectronico;
    private BigDecimal salarioBase;


    public void validar() {
        if (nombres == null || nombres.isBlank()) {
            throw new IllegalArgumentException("El campo nombres no puede estar vacío");
        }
        if (apellidos == null || apellidos.isBlank()) {
            throw new IllegalArgumentException("El campo apellidos no puede estar vacío");
        }
        if (correoElectronico == null || correoElectronico.isBlank()) {
            throw new IllegalArgumentException("El correo electrónico no puede estar vacío");
        }
        if (salarioBase == null || salarioBase.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor a 0");
        }
    }
}
