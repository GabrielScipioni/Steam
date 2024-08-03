package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByNombreAndPassword(String nombre, String password);
    UsuarioEntity findByNombre(String nombre);

}
