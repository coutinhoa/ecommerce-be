package warehouse.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;


@Data
@Setter
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class WarehouseProductDTO implements Serializable {

    private Long id;
    private String name;
    private String type;

    private double price;
    private String colour;

    private boolean premiumDelivery;
    private String identity;

    private int availableQuantity;

    private Set<PictureDTO> pictures;
    private Set<ReviewDTO> reviews;
    private Collection<SizeDTO> sizes;
}