package gabriel.dev.com.steam.Services.Impl;


import gabriel.dev.com.steam.Entities.CreadorEntity;
import gabriel.dev.com.steam.Entities.JuegoEntity;
import gabriel.dev.com.steam.Models.Creador;
import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Repositories.JuegoRepository;
import gabriel.dev.com.steam.Services.JuegoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class JuegoServiceImpl implements JuegoService {

    @Autowired
    private JuegoRepository juegoRepository;
    @Autowired
    private CreadorServiceImpl creadorService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
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
    @Override
    public Juego crearJuego(Genero genero, float precio, String creador, String nombre, String release){
        //crear un juego con los parametros pasados, validar que el creador exista, y setearle un rating de cero
        JuegoEntity juego = new JuegoEntity();
        juego.setGenero(genero);
        juego.setPrecio(precio);
        Creador c = creadorService.GetCreadoresByName(creador);
        CreadorEntity cE =modelMapper.map(c, CreadorEntity.class);
        juego.setCreador(cE);
        juego.setNombre(nombre);
        juego.setRelease(release);
        juego.setRating(0);
        return modelMapper.map(juegoRepository.save(juego),Juego.class);
    }
    @Override
    public List<Juego> BuscarJuegosPorFiltros(Genero genero, Integer ratingMax, Integer ratingMin, Float precioMax, Float precioMin, String nombre) {
        // Lista suprema que contendrá los juegos que coincidan con los filtros


        List<Juego> listaJuegosSuprema = todosLosJuegos();
        List<Juego> listaFiltrada = new ArrayList<>(listaJuegosSuprema);

        // Asignar valores por defecto si los filtros son null
        Integer ratingMaxFinal = (ratingMax != null) ? ratingMax : Integer.MAX_VALUE;
        Integer ratingMinFinal = (ratingMin != null) ? ratingMin : Integer.MIN_VALUE;
        Float precioMaxFinal = (precioMax != null) ? precioMax : Float.MAX_VALUE;
        Float precioMinFinal = (precioMin != null) ? precioMin : Float.MIN_VALUE;



        // Aplicar el filtro de género si no es null
        if (genero != null) {
            listaFiltrada.retainAll(buscarJuegoDeGenero(genero));
        }

        // Aplicar el filtro de rating usando los valores por defecto si no son nulls
        listaFiltrada.retainAll(buscarJuegoDeRating(ratingMaxFinal, ratingMinFinal));

        // Aplicar el filtro de precio usando los valores por defecto si no son nulls
        listaFiltrada.retainAll(buscarJuegoDePrecio(precioMaxFinal, precioMinFinal));

        // Aplicar el filtro de nombre si no es null ni vacío
        if (nombre != null && !nombre.isEmpty()) {
            listaFiltrada.retainAll(buscarJuegoDeNombre(nombre));
        }

        return new ArrayList<>(listaFiltrada);
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
    public List<Juego> todosLosJuegos(){
        //todo trae todos los juegos y lo devuleve como lista
        List<JuegoEntity> juegosEntity = juegoRepository.findAll();
        List<Juego> juegos = new ArrayList<>();
        for (JuegoEntity j : juegosEntity){
            juegos.add(modelMapper.map(j,Juego.class));
        }
        return juegos;
    }

    @Override
    public void calcularRatingall(List<Object[]> jugadoresPorJuego) {
        // Ordenar los juegos por cantidad de jugadores en orden descendente
        jugadoresPorJuego.sort((a, b) -> ((Long) b[1]).compareTo((Long) a[1]));

        // Asignar el rating a cada juego basado en la cantidad de jugadores
        int rating = 0;
        for (Object[] result : jugadoresPorJuego) {
            Long juegoId = (Long) result[0];
            JuegoEntity juegoEntity = juegoRepository.findById(juegoId).orElse(null);
            if (juegoEntity != null) {
                juegoEntity.setRating(rating++);
                juegoRepository.save(juegoEntity);
            }
        }
    }

    @Override
    public void actualizarRating(List<Object[]> jugadoresPorJuego) {
        calcularRatingall(jugadoresPorJuego);
    }
}
