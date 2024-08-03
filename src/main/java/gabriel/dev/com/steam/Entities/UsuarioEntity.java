package gabriel.dev.com.steam.Entities;

import gabriel.dev.com.steam.Models.Enums.Pais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

// > Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
// > Nombre
    private String Nombre;
    private String Password;
// > Pais
    @Enumerated(EnumType.STRING)
    private Pais Pais;
// > LastLogin
    private LocalDateTime LastLogin;
// > CreatedAt
    private LocalDateTime CreatedAt;
// > Nivel
    private Integer Nivel;
    private float Coins;

}
