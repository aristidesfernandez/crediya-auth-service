package co.com.powerup.r2dbc.entity;


import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.util.UUID;

@Table("usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {
    @Id
    @Column("usuario_id")
    private UUID id;
    private String nombres;

    private String apellidos;

    private String correoElectronico;

    private BigDecimal salarioBase;
}
