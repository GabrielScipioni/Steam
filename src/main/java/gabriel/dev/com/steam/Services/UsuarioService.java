package gabriel.dev.com.steam.Services;


import gabriel.dev.com.steam.Models.Enums.Pais;
import gabriel.dev.com.steam.Models.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    Usuario login(String nombre, String password);
    Usuario crearUsuario(String nombre, String password, Pais pais);
}
