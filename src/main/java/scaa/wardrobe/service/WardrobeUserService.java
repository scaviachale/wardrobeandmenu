package scaa.wardrobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scaa.wardrobe.model.WardrobeUser;
import scaa.wardrobe.repository.WardrobeUserRepository;

@Service
public class WardrobeUserService implements WardrobeUserServiceInterface {

    @Autowired
    WardrobeUserRepository wardrobeUserRepository;

    @Override
    public void createUser(WardrobeUser wardrobeUser) {
        wardrobeUserRepository.save(wardrobeUser);
    }
}
