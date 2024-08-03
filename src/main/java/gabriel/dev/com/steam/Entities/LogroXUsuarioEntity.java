package gabriel.dev.com.steam.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LogrosXUsuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogroXUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "Logro_Id")
    private LogroEntity Logro;
    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private UsuarioEntity Usuario;
}
