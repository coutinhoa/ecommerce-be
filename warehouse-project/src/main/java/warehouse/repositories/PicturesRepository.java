package warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.entities.Picture;

import java.util.Optional;

public interface PicturesRepository extends JpaRepository<Picture, Long> {
    Optional<Picture> findByGarmentId(Integer garment_id);

}
