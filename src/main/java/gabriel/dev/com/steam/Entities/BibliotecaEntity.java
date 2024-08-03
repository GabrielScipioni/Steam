package gabriel.dev.com.steam.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Biblioteca")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // IdJuego
    @ManyToOne
    @JoinColumn(name = "juego_Id")
    private JuegoEntity juego;

    // IdUsuario
    @ManyToOne
    @JoinColumn(name = "usuario_Id")
    private UsuarioEntity usuario;

    @Column(name = "horas")
    private Integer horas;

    @Column(name = "minutos")
    private Integer minutos;
}
