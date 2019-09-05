package scaa.wardrobe.repository;

import org.springframework.data.repository.CrudRepository;
import scaa.wardrobe.model.Cloth;

public interface WardrobeRepository extends CrudRepository<Cloth,Long> {

}
