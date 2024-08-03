package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByNombreAndPassword(String nombre, String password);
    Optional<UsuarioEntity> findByNombre(String nombre);

}
