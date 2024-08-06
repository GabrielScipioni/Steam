package gabriel.dev.com.steam.Controllers;

import gabriel.dev.com.steam.Dtos.JuegoDto;
import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/steam")
public class SteamController {
    @Autowired
    private JuegoService juegoService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/juegos/filtro")
    public ResponseEntity<List<JuegoDto>> getJuegos(
            @RequestParam(required = false) Genero genero,
            @RequestParam(required = false) Integer ratingMax,
            @RequestParam(required = false) Integer ratingMin,
            @RequestParam(required = false) Float precioMax,
            @RequestParam(required = false) Float precioMin,
            @RequestParam(required = false) String nombre) {

        List<Juego> juegos = juegoService.BuscarJuegosPorFiltros(genero,
                                                                 ratingMax,
                                                                 ratingMin,
                                                                 precioMax,
                                                                 precioMin,
                                                                 nombre);

        List<JuegoDto> juegoDtos = juegos.stream()
                .map(juego -> modelMapper.map(juego, JuegoDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(juegoDtos);
    }

    @PostMapping("/juego/publicar/{genero}&{precio}&{creador}&{nombre}&{release}")
    public ResponseEntity<JuegoDto> recordLap(@PathVariable("genero") Genero genero,
                                           @PathVariable("precio") float precio,
                                           @PathVariable("creador") String creador,
                                           @PathVariable("nombre") String nombre,
                                           @PathVariable("release") String release){
        return ResponseEntity.ok(modelMapper
                .map(juegoService.crearJuego(genero,precio,creador,nombre,release),JuegoDto.class));
    }
}
