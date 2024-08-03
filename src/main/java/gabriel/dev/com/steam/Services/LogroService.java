package gabriel.dev.com.steam.Services;

import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Models.Logro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogroService {

    void asignarLogros(List<String> logros, Juego juego);
    List<Logro> ObtenerLogros(Juego juego);
}
