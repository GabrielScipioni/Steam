package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.LogroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogroRepository extends JpaRepository<LogroEntity,Long> {
}
