package gabriel.dev.com.steam.Services.Impl;

import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Models.Logro;
import gabriel.dev.com.steam.Repositories.LogroRepository;
import gabriel.dev.com.steam.Services.LogroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogroServiceImpl implements LogroService {
    @Autowired
    private LogroRepository logroRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JuegoServiceImpl juegoService;

    public void asignarLogros(List<String> logros, Juego juego){
        //todo asignarle logros a un juego contemplar el caso de que un juego ya tenga logros, validar que el juego exista
    }
    public List<Logro> ObtenerLogros(Juego juego){
        //todo devolver todos los logros que tenga un juego
        return null;
    }
    public void calcularRatingJuego(Float porcentaje){
        //
    }
}
