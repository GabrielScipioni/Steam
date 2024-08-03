package gabriel.dev.com.steam.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private JuegoDto juego;
    private UsuarioDto usuario;
    private String Comentario;
}
