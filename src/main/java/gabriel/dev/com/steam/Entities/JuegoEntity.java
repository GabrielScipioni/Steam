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
    @Column(name = "nombre")
    private String nombre;
//   Release
    @Column(name = "release")
    private String release;
//   Precio
    @Column(name = "precio")
    private float precio;
//   IdGenero
    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private Genero genero;
//   Developer
    @ManyToOne
    @JoinColumn(name = "creador_Id")
    private CreadorEntity creador;
//   Rating
    @Column(name = "rating")
    private Integer rating;
}
