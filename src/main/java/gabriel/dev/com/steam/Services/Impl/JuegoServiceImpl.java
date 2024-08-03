package gabriel.dev.com.steam.Services.Impl;


import gabriel.dev.com.steam.Entities.CreadorEntity;
import gabriel.dev.com.steam.Entities.JuegoEntity;
import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Repositories.JuegoRepository;
import gabriel.dev.com.steam.Services.JuegoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        //se debera devolver los juegos asociados a un creador pasado por parametro, usar juegoRepository.findJuegosByCreadorNombre(nombreCreador)
        List<JuegoEntity> juegosEntity =juegoRepository.findJuegosByCreadorNombre(nombreCreador);
        if (juegosEntity.isEmpty()){
            return null;
        }
        List<Juego> juegos = new ArrayList<>();
        for (JuegoEntity j : juegosEntity){
            juegos.add(modelMapper.map(j , Juego.class));
        }
        return juegos;
    }

    public void crearJuego(Genero genero, float precio, String creador, String nombre, String release){
        //crear un juego con los parametros pasados, validar que el creador exista, y setearle un rating de cero
        JuegoEntity juego = new JuegoEntity();
        juego.setGenero(genero);
        juego.setPrecio(precio);
        juego.setCreador(modelMapper.map(creador, CreadorEntity.class));
        juego.setNombre(nombre);
        juego.setRelease(release);
        juego.setRating(0);
        juegoRepository.save(juego);
    }

    public List<Juego> BuscarJuegosPorFiltros(Genero genero, Integer ratingMax, Integer ratingMin, float precioMax, float precioMin, String nombre) {
        // Lista suprema que contendrá los juegos que coincidan con los filtros
        List<Juego> listaJuegosSuprema = new ArrayList<>();

        // Aplicar filtro de género si se proporciona
        if (genero != null) {
            listaJuegosSuprema.addAll(buscarJuegoDeGenero(genero));
        }

        // Aplicar filtro de rating si se proporcionan ambos límites
        if (ratingMax != null && ratingMin != null) {
            List<Juego> juegosRating = buscarJuegoDeRating(ratingMax, ratingMin);
            if (listaJuegosSuprema.isEmpty()) {
                listaJuegosSuprema.addAll(juegosRating);
            } else {
                listaJuegosSuprema.retainAll(juegosRating);
            }
        }

        // Aplicar filtro de precio si se proporcionan ambos límites
        if (precioMax != 0 && precioMin != 0) {
            List<Juego> juegosPrecio = buscarJuegoDePrecio(precioMax, precioMin);
            if (listaJuegosSuprema.isEmpty()) {
                listaJuegosSuprema.addAll(juegosPrecio);
            } else {
                listaJuegosSuprema.retainAll(juegosPrecio);
            }
        }

        // Aplicar filtro de nombre si se proporciona
        if (nombre != null) {
            List<Juego> juegosNombre = buscarJuegoDeNombre(nombre);
            if (listaJuegosSuprema.isEmpty()) {
                listaJuegosSuprema.addAll(juegosNombre);
            } else {
                listaJuegosSuprema.retainAll(juegosNombre);
            }
        }

        // Si no se proporciona ningún filtro, devolver todos los juegos
        if (genero == null && ratingMax == null && ratingMin == null && precioMax == 0 && precioMin == 0 && nombre == null) {
            return todosLosJuegos();
        }

        return new ArrayList<>(listaJuegosSuprema);
    }


    private List<Juego> buscarJuegoDeGenero(Genero genero){
        // devolver una lista de juegos de un genero especifico
        List<JuegoEntity> juegosEntity = juegoRepository.findByGenero(genero);
        List<Juego> juegos = new ArrayList<>();
        for (JuegoEntity j : juegosEntity){
            juegos.add(modelMapper.map(j,Juego.class));
        }
        return juegos;
    }
    private List<Juego> buscarJuegoDeRating(Integer RatingMax, Integer RatingMin){
        //devolver una lista de juegos de un rating entre valores especificos
        List<JuegoEntity> juegosEntity = juegoRepository.findByRating(RatingMax,RatingMin);
        List<Juego> juegos = new ArrayList<>();
        for (JuegoEntity j : juegosEntity){
            juegos.add(modelMapper.map(j,Juego.class));
        }
        return juegos;
    }
    private List<Juego> buscarJuegoDePrecio(float PrecioMax, float PrecioMin){
        //devolver una lista de juegos de un precio entre valores especificos
        List<JuegoEntity> juegosEntity = juegoRepository.findByPrecio(PrecioMax,PrecioMin);
        List<Juego> juegos = new ArrayList<>();
        for (JuegoEntity j : juegosEntity){
            juegos.add(modelMapper.map(j,Juego.class));
        }
        return juegos;
    }
    private List<Juego> buscarJuegoDeNombre(String nombre){
        //devolver una lista de juegos siempre que el nombre pasado por parametro tenga coincidencias de letras o palabras con los juegos en la base de datos
        List<JuegoEntity> juegosEntity = juegoRepository.findByNombre(nombre);
        List<Juego> juegos = new ArrayList<>();
        for (JuegoEntity j : juegosEntity){
            juegos.add(modelMapper.map(j,Juego.class));
        }
        return juegos;
    }
    private List<Juego> todosLosJuegos(){
        //todo trae todos los juegos y lo devuleve como lista
        List<JuegoEntity> juegosEntity = juegoRepository.findAll();
        List<Juego> juegos = new ArrayList<>();
        for (JuegoEntity j : juegosEntity){
            juegos.add(modelMapper.map(j,Juego.class));
        }
        return juegos;
    }

    /**
     * la verdad que no se me ocurre ahora como hacer esto, sea libre de agregarle parametros
     * o no hacerlo
     */
    public void calcularRatingall(){
        //todo metodo encargado de actualizar el rating de los juegos en base a su cantidad de jugadores. En caso de contar con misma cantidad de jugadores mantendran el mismo puesto, los demas juegos  le seguiran con el numero siguiente
    }
}
