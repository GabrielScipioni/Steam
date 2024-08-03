package gabriel.dev.com.steam.Services.Impl;


import gabriel.dev.com.steam.Entities.CreadorEntity;
import gabriel.dev.com.steam.Models.Creador;
import gabriel.dev.com.steam.Repositories.CreadorRepository;
import gabriel.dev.com.steam.Services.CreadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class CreadorServiceImpl implements CreadorService {

    @Autowired
    private CreadorRepository creadorRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Creador GetCreadoresByName (String nombre){
        // traer solo a un creador por el nombre (String) si es que existe, si no devolver un null
        Optional<CreadorEntity> optionalCreador = creadorRepository.findByNombre(nombre);
        if (optionalCreador.isEmpty()){
            return null;
        }
        return modelMapper.map(optionalCreador.get(),Creador.class);
    }
    @Override
    public ResponseEntity<String> crearCreador(String nombre) {
        // Verificar si el creador ya existe
        if (existeCreador(nombre)) {
            // Devolver una respuesta de BadRequest si el creador ya existe
            return new ResponseEntity<>("El creador ya existe", HttpStatus.BAD_REQUEST);
        }
        // Crear una nueva entidad Creador
        CreadorEntity creadorEntity = new CreadorEntity();
        creadorEntity.setNombre(nombre);

        // Guardar la entidad en la base de datos
        creadorRepository.save(creadorEntity);

        // Devolver una respuesta exitosa
        return new ResponseEntity<>("Creador creado exitosamente", HttpStatus.CREATED);
    }
    private boolean existeCreador(String nombre){
        //este metodo debe validar si un creador existe, true en el caso de que si, false en el caso de que no
        return creadorRepository.existsByNombre(nombre);
    }
}
