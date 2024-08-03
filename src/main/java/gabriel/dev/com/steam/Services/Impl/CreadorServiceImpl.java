package gabriel.dev.com.steam.Services.Impl;


import gabriel.dev.com.steam.Models.Creador;
import gabriel.dev.com.steam.Repositories.CreadorRepository;
import gabriel.dev.com.steam.Services.CreadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreadorServiceImpl implements CreadorService {

    @Autowired
    private CreadorRepository creadorRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Creador GetCreadoresByName (String nombre){
        //todo traer solo a un creador por el nombre (String) si es que existe, si no devolver un null
        return null;
    }
    public void CrearCreador (String nombre){
        //todo crear a un creador de videojuegos a partir del nombre, asegurarse de que no exista usando el metodo existeCreador(String), en tal caso devolver un error de badRequest
    }
    private boolean existeCreador(String nombre){
        //todo este metodo debe validar si un creador existe, true en el caso de que si, false en el caso de que no
        return false;
    }
}
