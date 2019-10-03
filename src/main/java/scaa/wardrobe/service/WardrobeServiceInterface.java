package scaa.wardrobe.service;

import scaa.wardrobe.model.Cloth;

import java.util.List;

public interface WardrobeServiceInterface {
    public void saveClothing(Cloth cloth);

    public List<Cloth> search(String keyword);

    public List<Cloth> viewAll();

    public Cloth getCloth(Long id);
}
