package gabriel.dev.com.steam.Services.Impl;


import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Repositories.JuegoRepository;
import gabriel.dev.com.steam.Services.JuegoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoServiceImpl implements JuegoService {

    @Autowired
    private JuegoRepository juegoRepository;
    @Autowired
    private CreadorServiceImpl creadorService;
    @Autowired
    private ModelMapper modelMapper;

    public List<Juego> busacarJuegosDeAutor(String nombreCreador){
        //todo se debera devolver los juegos asociados a un creador pasado por parametro, usar creadorService.GetCreadoresByName(nombreCreador)
        return null;
    }
    public void crearJuego(Genero genero, float precio, String creador, String nombre, String release){
        //todo crear un juego con los parametros pasados, validar que el creador exista, y setearle un rating de cero
    }

    public List<Juego> BuscarJuegosPorFiltros(Genero genero, Integer ratingMax, Integer ratingMin, float precioMax, float precioMin, String nombre){
        //todo devolver una lista de juegos en base a los filtros que no sean nulls, es decir si llega un genero de terror de precio max 10 y min 0 (siendo los demas parametros nulls) traer una lista (sin repetidos) de los juegos que tengan estas caracteristicas. En caso de pasarse el nombre no es necesario que este sea completamente acertado al nombre del juego (si se ingresa "fi" se devolvera los juegos del FIfa, FInal fantacy, hi-FI, free FIre, etc)
        return null;
    }

    private List<Juego> buscarJuegoDeGenero(Genero genero){
        //todo devolver una lista de juegos de un genero especifico
        return null;
    }
    private List<Juego> buscarJuegoDeRating(Integer RatingMax, Integer RatingMin){
        //todo devolver una lista de juegos de un rating entre valores especificos
        return null;
    }
    private List<Juego> buscarJuegoDePrecio(float RatingMax, float RatingMin){
        //todo devolver una lista de juegos de un precio entre valores especificos
        return null;
    }
    private List<Juego> buscarJuegoDeNombre(String nombre){
        //todo devolver una lista de juegos siempre que el nombre pasado por parametro tenga coincidencias de letras o palabras con los juegos en la base de datos
        return null;
    }
    private List<Juego> todosLosJuegos(){
        //todo trae todos los juegos y lo devuleve como lista
        return null;
    }

    /**
     * la verdad que no se me ocurre ahora como hacer esto, sea libre de agregarle parametros
     * o no hacerlo
     */
    public void calcularRatingall(){
        //todo metodo encargado de actualizar el rating de los juegos en base a su cantidad de jugadores. En caso de contar con misma cantidad de jugadores mantendran el mismo puesto, los demas juegos  le seguiran con el numero siguiente
    }
}
