package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.JuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, Long> {
    @Query("SELECT j FROM JuegoEntity j WHERE j.creador.nombre = :nombreCreador")
    List<JuegoEntity> findJuegosByCreadorNombre(@Param("nombreCreador") String nombreCreador);

}
