package warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import warehouse.entities.Review;

import java.util.Optional;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByGarmentId(Integer garment_id);
}
