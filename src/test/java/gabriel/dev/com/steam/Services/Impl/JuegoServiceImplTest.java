package gabriel.dev.com.steam.Services.Impl;

import gabriel.dev.com.steam.Entities.CreadorEntity;
import gabriel.dev.com.steam.Models.Creador;
import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Repositories.JuegoRepository;
import gabriel.dev.com.steam.Entities.JuegoEntity;  // Ensure you have this import
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.*;

@SpringBootTest
class JuegoServiceImplTest {

    @SpyBean
    JuegoServiceImpl juegoService;
    @MockBean
    JuegoRepository juegoRepository;
    @MockBean
    CreadorServiceImpl creadorService;
    @Autowired
    ModelMapper modelMapper;

    Juego juegoTest;
    Creador creadorTest;
    CreadorEntity creadorTestEntity;
    JuegoEntity juegoEntityTest;  // Add this
    List<Juego> juegos;
    List<JuegoEntity> juegoEntities;  // Add this

    @BeforeEach
    void setUp() {
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
    void buscarJuegosDeAutorTest() {
        when(juegoRepository.findJuegosByCreadorNombre("creadorTest")).thenReturn(juegoEntities);
        //when(modelMapper.map(juegoEntityTest, Juego.class)).thenReturn(juegoTest);

        List<Juego> result = juegoService.busacarJuegosDeAutor("creadorTest");
        assertEquals(1, result.size());
        assertEquals("juegoTest", result.get(0).getNombre());
    }
    @Test
    void buscarJuegosDeAutorTestCaseNull() {
        // Configura el comportamiento del mock para devolver una lista vacía
        when(juegoRepository.findJuegosByCreadorNombre("creadorTest")).thenReturn(new ArrayList<>());
        // Configura el comportamiento del mock del ModelMapper, aunque no se usará en este caso
        //when(modelMapper.map(juegoEntityTest, Juego.class)).thenReturn(juegoTest);

        // Llama al método bajo prueba
        List<Juego> result = juegoService.busacarJuegosDeAutor("creadorTest");

        // Verifica que el resultado sea null
        assertNull(result);
    }


    @Test
    void crearJuego() {
        // Mockear respuestas
        when(creadorService.GetCreadoresByName(creadorTest.getNombre())).thenReturn(creadorTest);
        when(juegoRepository.save(any(JuegoEntity.class))).thenReturn(juegoEntityTest);

        // Llamar al método a probar
        Juego resultado = juegoService.crearJuego(Genero.ACCION, 1.8F, "creadorTest", "juegoTest", "1.0.0");

        // Verificar el resultado
        assertNotNull(resultado);
        assertEquals(Genero.ACCION, resultado.getGenero());
        assertEquals(1.8F, resultado.getPrecio());
        assertEquals("juegoTest", resultado.getNombre());
        assertEquals("1.0.0", resultado.getRelease());
        assertEquals(1, resultado.getRating());

        // Verificar interacciones
        verify(creadorService, times(1)).GetCreadoresByName("creadorTest");
        verify(juegoRepository, times(1)).save(any(JuegoEntity.class));
    }

    @Test
    void todosLosJuegosTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    when(juegoRepository.findAll()).thenReturn(juegoEntities);
    //when(modelMapper.map(juegoEntityTest,Juego.class)).thenReturn(juegoTest);

        Method metodo = JuegoServiceImpl.class.getDeclaredMethod("todosLosJuegos");
        metodo.setAccessible(true);
        List<Juego> resultado = (List<Juego>) metodo.invoke(juegoService);
        Juego j = resultado.get(0);
        assertEquals(resultado.size(),1);
        assertEquals(j.getNombre(),juegoTest.getNombre());
    }

    @Test
    void buscarJuegoDeNombreTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    when(juegoRepository.findByNombre(anyString())).thenReturn(juegoEntities);
    //when(modelMapper.map(juegoEntityTest,Juego.class)).thenReturn(juegoTest);

        Method metodo = JuegoServiceImpl.class.getDeclaredMethod("buscarJuegoDeNombre",String.class);
        metodo.setAccessible(true);
        List<Juego> resultado = (List<Juego>) metodo.invoke(juegoService,"asdasd");
        Juego j = resultado.get(0);
        assertEquals(resultado.size(),1);
        assertEquals(j.getNombre(),juegoTest.getNombre());
    }

    @Test
    void buscarJuegoDePrecioTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    when(juegoRepository.findByPrecio(anyFloat(),anyFloat())).thenReturn(juegoEntities);
    //when(modelMapper.map(juegoEntityTest,Juego.class)).thenReturn(juegoTest);

        Method metodo = JuegoServiceImpl.class.getDeclaredMethod("buscarJuegoDePrecio",float.class,float.class);
        metodo.setAccessible(true);
        List<Juego> resultado = (List<Juego>) metodo.invoke(juegoService,1F,1F);
        Juego j = resultado.get(0);
        assertEquals(resultado.size(),1);
        assertEquals(j.getNombre(),juegoTest.getNombre());
    }

    @Test
    void buscarJuegoDeRatingTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    when(juegoRepository.findByRating(anyInt(), anyInt())).thenReturn(juegoEntities);
    //when(modelMapper.map(juegoEntityTest,Juego.class)).thenReturn(juegoTest);

        Method metodo = JuegoServiceImpl.class.getDeclaredMethod("buscarJuegoDeRating",Integer.class,Integer.class);
        metodo.setAccessible(true);
        List<Juego> resultado = (List<Juego>) metodo.invoke(juegoService,Integer.valueOf(1),Integer.valueOf(1));
        Juego j = resultado.get(0);
        assertEquals(resultado.size(),1);
        assertEquals(j.getNombre(),juegoTest.getNombre());
    }
    @Test
    void buscarJuegoDeGeneroTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(juegoRepository.findByGenero(any(Genero.class))).thenReturn(juegoEntities);
        //when(modelMapper.map(juegoEntityTest,Juego.class)).thenReturn(juegoTest);

        Method metodo = JuegoServiceImpl.class.getDeclaredMethod("buscarJuegoDeGenero",Genero.class);
        metodo.setAccessible(true);
        List<Juego> resultado = (List<Juego>) metodo.invoke(juegoService,Genero.ACCION);
        Juego j = resultado.get(0);
        assertEquals(resultado.size(),1);
        assertEquals(j.getNombre(),juegoTest.getNombre());
    }



    void configurarMocks() {
        when(juegoRepository.findAll()).thenReturn(juegoEntities);
        when(juegoRepository.findByGenero(any(Genero.class))).thenReturn(juegoEntities);
        when(juegoRepository.findByRating(anyInt(), anyInt())).thenReturn(juegoEntities);
        when(juegoRepository.findByPrecio(anyFloat(), anyFloat())).thenReturn(juegoEntities);
        when(juegoRepository.findByNombre(anyString())).thenReturn(juegoEntities);
        //when(modelMapper.map(any(JuegoEntity.class), eq(Juego.class))).thenReturn(juegoTest);
    }

    @Test
    void buscarJuegosPorFiltrosSinFiltrosTest() {
        configurarMocks();
        List<Juego> resultado = juegoService.BuscarJuegosPorFiltros(null, null, null, null, null, null);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals(juegoTest.getNombre(), resultado.get(0).getNombre());
    }

    @Test
    void buscarJuegosPorFiltrosConGeneroTest() {
        configurarMocks();
        List<Juego> resultado = juegoService.BuscarJuegosPorFiltros(Genero.ACCION, null, null, null, null, null);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals(juegoTest.getNombre(), resultado.get(0).getNombre());
    }

    @Test
    void buscarJuegosPorFiltrosConRatingTest() {
        configurarMocks();
        List<Juego> resultado = juegoService.BuscarJuegosPorFiltros(null, 5, 1, null, null, null);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals(juegoTest.getNombre(), resultado.get(0).getNombre());
    }

    @Test
    void buscarJuegosPorFiltrosConPrecioTest() {
        configurarMocks();
        List<Juego> resultado = juegoService.BuscarJuegosPorFiltros(null, null, null, 2.0F, 1.0F, null);
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals(juegoTest.getNombre(), resultado.get(0).getNombre());
    }

    @Test
    void buscarJuegosPorFiltrosConNombreTest() {
        configurarMocks();
        List<Juego> resultado = juegoService.BuscarJuegosPorFiltros(null, null, null, null, null, "juegoTest");
        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals(juegoTest.getNombre(), resultado.get(0).getNombre());
    }

}
