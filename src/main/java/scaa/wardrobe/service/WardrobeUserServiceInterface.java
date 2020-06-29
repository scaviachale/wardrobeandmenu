package scaa.wardrobe.service;

import scaa.wardrobe.model.WardrobeUserDTO;

import java.util.List;

public interface WardrobeUserServiceInterface {
    void createUser(WardrobeUserDTO wardrobeUserDTO);

    List getUsers();
}
