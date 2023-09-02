package warehouse.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "sizes")

public class Size {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "sizes", nullable = false)
    @NonNull
    private String size;

    @ManyToMany(mappedBy = "sizes", cascade = {CascadeType.ALL})
    @ToString.Exclude
    private Set<WarehouseProduct> garments = new HashSet<WarehouseProduct>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Size size = (Size) o;
        return getId() != null && Objects.equals(getId(), size.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


