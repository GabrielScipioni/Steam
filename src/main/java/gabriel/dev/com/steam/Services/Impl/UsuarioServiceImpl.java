package gabriel.dev.com.steam.Services.Impl;


import gabriel.dev.com.steam.Models.Enums.Pais;
import gabriel.dev.com.steam.Models.Usuario;
import gabriel.dev.com.steam.Repositories.UsuarioRepository;
import gabriel.dev.com.steam.Services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Usuario login(String nombre, String password){
        //Todo usar findByNombreAndPassword() para logear, en el caso de que no exista devolver un error, en el caso de poder logearse actualizar lastLogin a la fecha actual
        return null;
    }
    public Usuario crearUsuario(String nombre, String password, Pais pais){
        //todo crear un usuario, en el caso de que el nombre de usuario ya este en uso, lanzar un error de que no se ha podido crear el usuario, devolver un usuario con los datos pasados (nombre, password, pais) setear el usuario con la fecha de creacion actual, la misma del ultimo login y el nivel en cero
        return null;
    }
    private boolean existeNombreUsuario(String nombre){
        //todo usar el parametro para buscar un usuario con ese mismo nombre, en caso de existir devolver true. Caso contrario, devolver false utilizar findByNombre()
        return false;
    }
    public void updateNiveles(Integer niveles, Usuario usuario){
        //todo actualizar los niveles de un usuario especifico
    }
}
