package gabriel.dev.com.steam.Repositories;


import gabriel.dev.com.steam.Entities.CreadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreadorRepository extends JpaRepository<CreadorEntity, Long> {
}
