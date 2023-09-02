package warehouse.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import static jakarta.persistence.GenerationType.IDENTITY;

@ToString
@NoArgsConstructor
@Entity
@Table(name = "garmentsizes")
@Component
public class GarmentSize {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}

