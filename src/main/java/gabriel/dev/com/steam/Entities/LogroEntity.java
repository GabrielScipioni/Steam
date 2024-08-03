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
    @JoinColumn(name = "juego_Id")
    private JuegoEntity juego;
    @Column(name = "logro")
    private String logro;
}
