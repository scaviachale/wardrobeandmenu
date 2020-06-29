package scaa.wardrobe.repository;

import org.springframework.data.repository.CrudRepository;
import scaa.wardrobe.model.WardrobeUserEntity;

import java.util.List;

public interface WardrobeUserRepository extends CrudRepository<WardrobeUserEntity, Long> {

    List<WardrobeUserEntity> findAll();
}
