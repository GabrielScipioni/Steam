package gabriel.dev.com.steam.Services;

import gabriel.dev.com.steam.Models.Biblioteca;
import gabriel.dev.com.steam.Models.Juego;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BibliotecaService  {
    List<Biblioteca> ObtenerJuegosDeUsuario(String nombre, String password);
    boolean usuarioTieneJuego(String nombre, String password, Juego juego);
    void comprarJuego(String nombre, String password, Juego juego);
    void jugar(String nombre, String password, String nombreJuego, Integer horas, Integer minutos);
}
