package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.CreadorEntity;
import gabriel.dev.com.steam.Entities.JuegoEntity;
import gabriel.dev.com.steam.Models.Enums.Genero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class JuegoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private JuegoRepository juegoRepository;

    @Test
    void findJuegosByCreadorNombreTest () {
        List<JuegoEntity> resultado = juegoRepository.findJuegosByCreadorNombre("Shigeru Miyamoto");
        assertNotNull(resultado.get(0));
        assertEquals(resultado.get(0).getNombre(),"Mario Bros");
    }

    @Test
    void findByGeneroTest () {
        List<JuegoEntity> resultado = juegoRepository.findByGenero(Genero.RPG);
        assertNotNull(resultado.get(0));
    }

    @Test
    void findByRatingTest () {
        List<JuegoEntity> resultado = juegoRepository.findByRating(5,1);
        assertNotNull(resultado.get(0));
    }

    @Test
    void findByPrecioTest () {
        List<JuegoEntity> resultado = juegoRepository.findByPrecio(0f,0f);
        assertNotNull(resultado.get(0));
    }

    @Test
    void findByNombreTest () {
        List<JuegoEntity> resultado = juegoRepository.findByNombre("delta");
        assertNotNull(resultado.get(0));
    }

}
