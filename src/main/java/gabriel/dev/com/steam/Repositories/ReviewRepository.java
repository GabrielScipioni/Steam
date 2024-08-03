package gabriel.dev.com.steam.Repositories;

import gabriel.dev.com.steam.Entities.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
}
