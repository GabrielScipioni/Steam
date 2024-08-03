package gabriel.dev.com.steam.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteca {
    private Long id;
    private Juego juego;
    private Usuario usuario;
    private Integer horas;
    private Integer minutos;

}
