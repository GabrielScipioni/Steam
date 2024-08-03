package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.LogroXUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogroXUsuarioRepository extends JpaRepository<LogroXUsuarioEntity,Long> {
}
