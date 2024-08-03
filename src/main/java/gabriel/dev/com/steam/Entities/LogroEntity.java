package gabriel.dev.com.steam.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Logros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "Juego_Id")
    private JuegoEntity Juego;

    private String Logro;
}
