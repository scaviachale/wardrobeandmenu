package scaa.wardrobe.repository;

import org.springframework.data.repository.CrudRepository;
import scaa.wardrobe.model.WardrobeUser;

public interface WardrobeUserRepositoryInterface extends CrudRepository<WardrobeUser, Long> {
}
