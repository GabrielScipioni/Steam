package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.JuegoEntity;
import gabriel.dev.com.steam.Models.Enums.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, Long> {
    @Query("SELECT j FROM JuegoEntity j WHERE j.creador.nombre = :nombreCreador")
    List<JuegoEntity> findJuegosByCreadorNombre(@Param("nombreCreador") String nombreCreador);

    List<JuegoEntity> findByGenero (Genero genero);

    @Query("select j from JuegoEntity j where j.rating < :ratingMax and j.rating > :ratingMin")
    List<JuegoEntity> findByRating (@Param("ratingMax") Integer ratingMax, @Param("ratingMin") Integer ratingMin);

    @Query("select j from JuegoEntity j where j.precio < :precioMax and j.precio > :precioMin")
    List<JuegoEntity> findByPrecio(@Param("precioMax") float precioMax, @Param("precioMin") float precioMin);

    @Query("SELECT j FROM JuegoEntity j WHERE LOWER(j.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<JuegoEntity> findByNombre(@Param("nombre") String nombre);
}
