package gabriel.dev.com.steam.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogroDto {
    private Long id;
    private JuegoDto juego;
    private String Logro;
}
