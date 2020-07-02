package scaa.wardrobe.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scaa.wardrobe.model.WardrobeUserDTO;
import scaa.wardrobe.model.WardrobeUserEntity;
import scaa.wardrobe.repository.WardrobeUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WardrobeUserService implements WardrobeUserServiceInterface {

    @Autowired
    private WardrobeUserRepository wardrobeUserRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createUser(WardrobeUserDTO wardrobeUserDTO) {
        final WardrobeUserEntity wardrobeUserEntity = modelMapper.map(wardrobeUserDTO, WardrobeUserEntity.class);
        wardrobeUserRepository.save(wardrobeUserEntity);
    }

    @Override
    public List<WardrobeUserDTO> getUsers() {
        final List<WardrobeUserEntity> wardrobeUserEntities = wardrobeUserRepository.findAll();
        return wardrobeUserEntities
                .stream()
                .map(wardrobeUserEntity -> modelMapper.map(wardrobeUserEntity, WardrobeUserDTO.class))
                .collect(Collectors.toList());
    }

}
