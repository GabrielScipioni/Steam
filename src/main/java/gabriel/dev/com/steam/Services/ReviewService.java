package gabriel.dev.com.steam.Services;


import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Models.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService  {
    void agregarReview(String nombre, String password, Juego juego, String comentario);
}
