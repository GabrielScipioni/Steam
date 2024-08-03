package gabriel.dev.com.steam.Services.Impl;


import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Models.Logro;
import gabriel.dev.com.steam.Models.Usuario;
import gabriel.dev.com.steam.Repositories.LogroXUsuarioRepository;
import gabriel.dev.com.steam.Services.LogroXUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogroXUsuarioServiceImpl implements LogroXUsuarioService {
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

    public void conseguirLogro(Juego juego, String logro, String nombre, String password){
        //todo  validar que el usuario tenga en su biblioteca ese juego, en caso de que si, asignarle un logro al usuario (primero logeandolo) en base al nombre del logro, en caso de que no lo tenga devolver algun error
    }
}
