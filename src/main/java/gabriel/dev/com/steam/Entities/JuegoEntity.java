package gabriel.dev.com.steam.Entities;

import gabriel.dev.com.steam.Models.Enums.Genero;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Juegos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JuegoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

//   Nombre
    private String Nombre;
//   Release
    private String Release;
//   Precio
    private float Precio;
//   IdGenero
    @Enumerated(EnumType.STRING)
    private Genero Genero;
//   Developer
    @ManyToOne
    @JoinColumn(name = "Creador_Id")
    private CreadorEntity Creador;
//   Rating
    private Integer Rating;
}
