package gabriel.dev.com.steam.Models;


import gabriel.dev.com.steam.Entities.CreadorEntity;
import gabriel.dev.com.steam.Models.Enums.Genero;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Juego {
    private Long id;
    private String Nombre;
    private String Release;
    private float Precio;
    private Genero Genero;
    private Creador Creador;
    private Integer Rating;
}
