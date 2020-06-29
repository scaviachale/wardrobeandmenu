package scaa.wardrobe.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scaa.wardrobe.model.WardrobeUser;
import scaa.wardrobe.model.WardrobeUserEntity;
import scaa.wardrobe.repository.WardrobeUserRepository;

import java.util.List;

@Service
public class WardrobeUserService implements WardrobeUserServiceInterface {

    @Autowired
    private WardrobeUserRepository wardrobeUserRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createUser(WardrobeUser wardrobeUser) {
        final WardrobeUserEntity wardrobeUserEntity = modelMapper.map(wardrobeUser, WardrobeUserEntity.class);
        wardrobeUserRepository.save(wardrobeUserEntity);
    }

    @Override
    public List<WardrobeUserEntity> getUsers() {
        return wardrobeUserRepository.findAll();
    }

}
