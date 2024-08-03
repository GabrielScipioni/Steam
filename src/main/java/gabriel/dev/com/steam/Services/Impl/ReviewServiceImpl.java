package gabriel.dev.com.steam.Services.Impl;


import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Models.Usuario;
import gabriel.dev.com.steam.Repositories.LogroXUsuarioRepository;
import gabriel.dev.com.steam.Services.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private LogroXUsuarioRepository logroXUsuarioRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LogroServiceImpl logroService;
    @Autowired
    private UsuarioServiceImpl usuarioService;
    @Autowired
    private BibliotecaServiceImpl bibliotecaService;
    @Override
    public void agregarReview(String nombre, String password, Juego juego, String comentario){
        //todo agregar la review a un juego, logear al usuario utilizar el metodo minarNivel() para agregarle (o no) niveles al usuario
    }

    private Integer minarNivel(Usuario usuario, Juego juego){
        //todo validar que el usuario no haya comentado en un juego que ya haya comentado anteriormente. De manera random cada 5 Reviews que haga un usuario, posibilitar aumentar su nivel. si el usuario es nivel 30 o inferior darle 5 niveles, si es nivel 50 o inferior darle 3 niveles, si supera los 50 darle 1 nivel. La posibilidad de que el usuario tenga niveles es del 20%
        return null;
    }

    private boolean usuarioComento(Usuario usuario, Juego juego){
        //todo si el usuario ya ha comentado en el juego devolver true, caso contrario false
        return false;
    }
}
