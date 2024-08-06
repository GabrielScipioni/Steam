package gabriel.dev.com.steam.Controllers;

import gabriel.dev.com.steam.Dtos.JuegoDto;
import gabriel.dev.com.steam.Models.Enums.Genero;
import gabriel.dev.com.steam.Models.Juego;
import gabriel.dev.com.steam.Services.JuegoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SteamController.class)
public class SteamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JuegoService juegoService;

    @MockBean
    private ModelMapper modelMapper;

    private List<Juego> juegoList;
    private JuegoDto juegoDto;

    @BeforeEach
    void setUp() {
        // Configurar datos de prueba
        juegoList = new ArrayList<>();
        Juego juego = new Juego();
        juego.setId(1L); // Asegúrate de que el objeto Juego tenga un id
        juegoList.add(juego);

        // Configurar JuegoDto de prueba
        juegoDto = new JuegoDto();
        juegoDto.setId(1L);
        juegoDto.setNombre("JuegoPrueba");
        juegoDto.setRelease("2023-01-01");
        juegoDto.setPrecio(29.99f);
        juegoDto.setGenero(Genero.FPS);
        juegoDto.setRating(5);
        // CreadorDto y otros campos pueden ser configurados aquí si es necesario
    }

    @Test
    void testGetJuegos() throws Exception {
        // Configurar comportamiento del servicio
        when(juegoService.BuscarJuegosPorFiltros(any(), any(), any(), any(), any(), anyString())).thenReturn(juegoList);
        when(modelMapper.map(any(Juego.class), eq(JuegoDto.class))).thenReturn(juegoDto);

        mockMvc.perform(get("/steam/juegos/filtro")
                        .param("genero", Genero.FPS.toString())
                        .param("ratingMax", "5")
                        .param("ratingMin", "1")
                        .param("precioMax", "50.0")
                        .param("precioMin", "10.0")
                        .param("nombre", "Ju")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1L)) // Verifica que el primer objeto del array tenga un id de 1
                .andExpect(jsonPath("$[0].nombre").value("JuegoPrueba")) // Verifica que el nombre coincida
                .andExpect(jsonPath("$[0].precio").value(29.99f)) // Verifica que el precio coincida
                .andExpect(jsonPath("$[0].genero").value(Genero.FPS.toString())) // Verifica que el género coincida
                .andExpect(jsonPath("$[0].rating").value(5)); // Verifica que el rating coincida
        System.out.println();
    }
}
