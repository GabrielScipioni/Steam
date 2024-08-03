package gabriel.dev.com.steam.Dtos;


import gabriel.dev.com.steam.Models.Enums.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoDto {
    private Long id;
    private String Nombre;
    private String Release;
    private float Precio;
    private Genero Genero;
    private CreadorDto Creador;
    private Integer Rating;
}
