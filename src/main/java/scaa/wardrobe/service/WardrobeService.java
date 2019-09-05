package scaa.wardrobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import scaa.wardrobe.model.Cloth;
import scaa.wardrobe.model.GenerateClothNumber;
import scaa.wardrobe.repository.WardrobeRepository;

@Service
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class WardrobeService implements WardrobeServiceInterface {

    @Autowired
    WardrobeRepository wardrobeRepository;

    @Override
    public void saveClothing(Cloth cloth) {
        cloth.setClothNumber(GenerateClothNumber.generateRandomString(6));
        wardrobeRepository.save(cloth);
        //emailService.clothingAddedNotification();
    }
}
