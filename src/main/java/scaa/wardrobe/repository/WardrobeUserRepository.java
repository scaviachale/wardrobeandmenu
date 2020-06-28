package scaa.wardrobe.repository;

import org.springframework.data.repository.CrudRepository;
import scaa.wardrobe.model.WardrobeUser;

public interface WardrobeUserRepository extends CrudRepository<WardrobeUser, Long> {
}
