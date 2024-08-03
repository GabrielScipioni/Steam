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
    @JoinColumn(name = "Juego_Id")
    private JuegoEntity Juego;

    // IdUsuario
    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private UsuarioEntity Usuario;

    @Column(name = "Horas")
    private Integer Horas;

    @Column(name = "Minutos")
    private Integer Minutos;
}
