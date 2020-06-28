package scaa.wardrobe.repository;

import org.springframework.data.repository.CrudRepository;
import scaa.wardrobe.model.WardrobeUser;

import java.util.List;

public interface WardrobeUserRepository extends CrudRepository<WardrobeUser, Long> {

    List<WardrobeUser> findAll();
}
