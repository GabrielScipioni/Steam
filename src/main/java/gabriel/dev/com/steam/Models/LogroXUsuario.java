package gabriel.dev.com.steam.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogroXUsuario {
    private Long id;
    private Logro logro;
    private Usuario usuario;

}
