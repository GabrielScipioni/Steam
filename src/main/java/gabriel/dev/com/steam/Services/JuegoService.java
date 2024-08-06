package gabriel.dev.com.steam.Services;


import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JuegoService {
    List<Juego> busacarJuegosDeAutor(String nombreCreador);

    Juego crearJuego(Genero genero, float precio, String creador, String nombre, String release);

    List<Juego> BuscarJuegosPorFiltros(Genero genero, Integer ratingMax, Integer ratingMin, Float precioMax, Float precioMin, String nombre);

    void calcularRatingall(List<Object[]> jugadoresPorJuego);
    void actualizarRating(List<Object[]> jugadoresPorJuego);
}
