package gabriel.dev.com.steam.Services;


import gabriel.dev.com.steam.Models.Creador;
import org.springframework.stereotype.Service;

@Service
public interface CreadorService {
    Creador GetCreadoresByName (String nombre);
    void CrearCreador (String nombre);
}
