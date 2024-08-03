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
    @JoinColumn(name = "Juego_Id")
    private JuegoEntity Juego;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private UsuarioEntity Usuario;

    private String Comentario;
}
