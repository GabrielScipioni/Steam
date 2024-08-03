package gabriel.dev.com.steam.Repositories;


import gabriel.dev.com.steam.Entities.CreadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreadorRepository extends JpaRepository<CreadorEntity, Long> {

    Optional<CreadorEntity> findByNombre (String nombre);
    boolean existsByNombre (String nombre);
}
