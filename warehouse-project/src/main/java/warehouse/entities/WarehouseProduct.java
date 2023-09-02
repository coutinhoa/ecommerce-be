package warehouse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "products")
public class WarehouseProduct {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "type", nullable = false)
    @NonNull
    private String type;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "colour", nullable = false)
    @NonNull
    private String colour;

    @Column(name = "premium_delivery", nullable = false)
    private boolean premiumDelivery;

    @Column(name = "identity", nullable = false)
    @NonNull
    private String identity;

    @Column(name = "available_quantity", nullable = false)
    private int availableQuantity;


    @OneToMany(mappedBy = "garment")
    @ToString.Exclude
    //cascade = CascadeType.ALL, orphanRemoval = true
    private Set<Picture> pictures;

    @OneToMany(mappedBy = "garment")
    @ToString.Exclude
    private Set<Review> reviews;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "garmentsizes", joinColumns = @JoinColumn(name = "garment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "size_id", referencedColumnName = "id"))
    @ToString.Exclude
    //Set < Sizes > sizes = new HashSet< Sizes >();
    private Collection<Size> sizes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        WarehouseProduct product = (WarehouseProduct) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}