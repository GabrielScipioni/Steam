package gabriel.dev.com.steam.Services;


import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Models.Logro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogroXUsuarioService {
    void conseguirLogro(Juego juego, String logro, String nombre, String password);
}
