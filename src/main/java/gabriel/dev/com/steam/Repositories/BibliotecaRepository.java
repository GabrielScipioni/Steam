package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.BibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository <BibliotecaEntity, Long> {
}
