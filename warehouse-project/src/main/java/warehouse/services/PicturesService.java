package warehouse.services;

import org.springframework.stereotype.Service;
import warehouse.entities.Picture;
import warehouse.repositories.PicturesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PicturesService {

    private final PicturesRepository repository;

    PicturesService(PicturesRepository repository) {
        this.repository = repository;
    }

    public List<Picture> getAll() {
        return repository.findAll();
    }
    /*public Optional<Pictures> getPicturesByGarmentId(Integer garment_id){
        return repository.findByGarmentId(garment_id);
    }*/

    public Optional<Picture> getPictures(Integer garment_id) {
        return repository.findByGarmentId(garment_id);
    }
}
