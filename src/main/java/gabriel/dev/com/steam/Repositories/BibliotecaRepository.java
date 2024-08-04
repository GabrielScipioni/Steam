package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.BibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliotecaRepository extends JpaRepository <BibliotecaEntity, Long> {

    @Query("SELECT b.juego.Id, COUNT(b.usuario.id) FROM BibliotecaEntity b GROUP BY b.juego.Id")
    List<Object[]> countPlayersByJuego();

}
