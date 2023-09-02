package warehouse.exceptions;

public class GarmentNotFoundException extends RuntimeException {

    public GarmentNotFoundException(Long id) {
        super("Could not find garment " + id);
    }
}
