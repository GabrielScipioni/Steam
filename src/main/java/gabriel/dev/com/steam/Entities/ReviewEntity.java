package gabriel.dev.com.steam.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "juego_Id")
    private JuegoEntity juego;

    @ManyToOne
    @JoinColumn(name = "usuario_Id")
    private UsuarioEntity usuario;
    @Column(name = "comentario")
    private String comentario;
}
