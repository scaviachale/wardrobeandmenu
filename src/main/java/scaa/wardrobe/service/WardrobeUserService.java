package scaa.wardrobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scaa.wardrobe.model.WardrobeUser;
import scaa.wardrobe.repository.WardrobeUserRepositoryInterface;

@Service
public class WardrobeUserService implements WardrobeUserServiceInterface {

    @Autowired
    WardrobeUserRepositoryInterface wardrobeUserRepositoryInterface;

    @Override
    public void createUser(WardrobeUser wardrobeUser) {
        wardrobeUserRepositoryInterface.save(wardrobeUser);
    }
}
