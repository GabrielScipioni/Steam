package gabriel.dev.com.steam.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogroXUsuarioDto {
    private Long id;
    private LogroDto logro;
    private UsuarioDto usuario;

}
