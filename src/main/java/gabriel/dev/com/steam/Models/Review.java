package gabriel.dev.com.steam.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Long id;
    private Juego juego;
    private Usuario usuario;
    private String Comentario;
}
