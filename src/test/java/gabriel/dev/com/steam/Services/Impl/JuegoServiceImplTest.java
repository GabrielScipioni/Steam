package gabriel.dev.com.steam.Services.Impl;

import gabriel.dev.com.steam.Entities.CreadorEntity;
import gabriel.dev.com.steam.Models.Creador;
import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Repositories.JuegoRepository;
import gabriel.dev.com.steam.Entities.JuegoEntity;  // Ensure you have this import
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class JuegoServiceImplTest {

    @InjectMocks
    JuegoServiceImpl juegoService;
    @Mock
    JuegoRepository juegoRepository;
    @Mock
    CreadorServiceImpl creadorService;
    @Mock
    ModelMapper modelMapper;

    Juego juegoTest;
    Creador creadorTest;
    CreadorEntity creadorTestEntity;
    JuegoEntity juegoEntityTest;  // Add this
    List<Juego> juegos;
    List<JuegoEntity> juegoEntities;  // Add this

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        creadorTest = new Creador(1L,"creadorTest");
        creadorTestEntity = new CreadorEntity(1L,"creadorTest");

        juegoTest = new Juego();
        juegoTest.setId(1L);
        juegoTest.setNombre("juegoTest");
        juegoTest.setRelease("1.0.0");
        juegoTest.setPrecio(1.8F);
        juegoTest.setGenero(Genero.ACCION);
        juegoTest.setCreador(creadorTest);
        juegoTest.setRating(1);
        juegos = new ArrayList<>();
        juegos.add(juegoTest);

        juegoEntityTest = new JuegoEntity();  // Create JuegoEntity instance
        juegoEntityTest.setId(1L);
        juegoEntityTest.setNombre("juegoTest");
        juegoEntityTest.setRelease("1.0.0");
        juegoEntityTest.setPrecio(1.8F);
        juegoEntityTest.setGenero(Genero.ACCION);
        juegoEntityTest.setCreador(creadorTestEntity);  // Assuming Creador is an entity too
        juegoEntityTest.setRating(1);
        juegoEntities = new ArrayList<>();
        juegoEntities.add(juegoEntityTest);
    }

    @Test
    void buscarJuegosDeAutor() {
        when(juegoRepository.findJuegosByCreadorNombre("creadorTest")).thenReturn(juegoEntities);
        when(modelMapper.map(juegoEntityTest, Juego.class)).thenReturn(juegoTest);

        List<Juego> result = juegoService.busacarJuegosDeAutor("creadorTest");
        assertEquals(1, result.size());
        assertEquals("juegoTest", result.get(0).getNombre());
    }

    @Test
    void crearJuego() {
        // Mock the modelMapper to return creadorTestEntity when mapping the creator name to CreadorEntity
        when(modelMapper.map("creadorTest", CreadorEntity.class)).thenReturn(creadorTestEntity);

        // Call the method to test
        juegoService.crearJuego(Genero.ACCION, 1.8F, "creadorTest", "juegoTest", "1.0.0");

        // Verify that the juegoRepository's save method was called once
        verify(juegoRepository, times(1)).save(any(JuegoEntity.class));

        // Verify that the save method was called with a JuegoEntity having the expected properties
        verify(juegoRepository).save(argThat(juego ->
                juego.getGenero() == Genero.ACCION &&
                        juego.getPrecio() == 1.8F &&
                        juego.getNombre().equals("juegoTest") &&
                        juego.getRelease().equals("1.0.0") &&
                        juego.getCreador().equals(creadorTestEntity) &&
                        juego.getRating() == 0
        ));
    }

    @Test
    void buscarJuegosPorFiltros() {
        Genero genero = Genero.ACCION;
        Integer ratingMax = null;
        Integer ratingMin = null;
        Float precioMax = null;
        Float precioMin = null;
        String nombre = null;
        when(juegoRepository.findByGenero(genero)).thenReturn(juegoEntities);
        when(modelMapper.map(any(), Juego.class)).thenReturn(juegoTest);

    }
    @Test
    void calcularRatingall() {
    }
}
