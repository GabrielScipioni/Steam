package gabriel.dev.com.steam.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logro {
    private Long id;
    private Juego juego;
    private String Logro;
}
