package scaa.wardrobe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import scaa.wardrobe.model.Cloth;

import java.util.List;

public interface WardrobeRepository extends CrudRepository<Cloth, Long> {

    @Query(value = "SELECT c FROM Cloth c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.clothNumber LIKE '%' || :keyword || '%'"
            + " OR c.size LIKE '%' || :keyword || '%'")
    public List<Cloth> search(@Param("keyword") String keyword);
}
