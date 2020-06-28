package scaa.wardrobe.service;

import scaa.wardrobe.model.WardrobeUser;

import java.util.List;

public interface WardrobeUserServiceInterface {
    void createUser(WardrobeUser wardrobeUser);

    List getUsers();
}
