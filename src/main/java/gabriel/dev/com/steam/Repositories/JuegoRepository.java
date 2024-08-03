package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.JuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, Long> {
}
