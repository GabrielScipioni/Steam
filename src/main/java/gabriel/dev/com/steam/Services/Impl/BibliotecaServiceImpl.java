package gabriel.dev.com.steam.Services.Impl;

import gabriel.dev.com.steam.Models.Biblioteca;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Repositories.BibliotecaRepository;
import gabriel.dev.com.steam.Services.BibliotecaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaServiceImpl implements BibliotecaService {
    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private JuegoServiceImpl juegoService;
    @Override
    public List<Biblioteca> ObtenerJuegosDeUsuario(String nombre, String password){
        //todo obtener la lista de juegos de un usuario (biblioteca) a partir de el nombre de usuario y su contraseña, cada vez que se utilice esto el usuario debe actualizar su ultima fecha de conexion usuarioService.login()
        return null;
    }
    @Override
    public boolean usuarioTieneJuego(String nombre, String password, Juego juego){
        //TODO validar que el usuario cuente con el juego pasado por parametro, no se tiene que logear el usuario, devolver true si tiene el juego, false en caso contrario
        return false;
    }
    @Override
    public void comprarJuego(String nombre, String password, Juego juego){
        //todo obtener al usuario y restarle el precio del juego. luego guardar el juego dentro de la biblioteca del usuario seteando los minutos, horas en cero y sumarle 5 niveles al usuario. ademas actualizar el rating de todos los juego con juegoService.calcularRatingall() y guardar todos los cambios
    }
    @Override
    public void jugar(String nombre, String password, String nombreJuego, Integer horas, Integer minutos){
        //todo el usuario se logueara y se le sumaran las horas a su juego, los minutos en caso de pasarse de los 60 deberan transformarse en 1 hora, 2 horas si superan los 120 minutos y asi secuencialmente, los minutos sobrantes de la convercion se sumaran a los minutos
    }
    private void minutosAHoras(Integer horas, Integer minutos){
        //todo seteara las horas que pueden ocupar los minutos pasados por parametro, y seteara los minutos sobrantes
    }
}
