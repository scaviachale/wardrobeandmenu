package scaa.wardrobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import scaa.wardrobe.email.EmailService;
import scaa.wardrobe.email.EmailType;
import scaa.wardrobe.model.Cloth;
import scaa.wardrobe.model.GenerateClothNumber;
import scaa.wardrobe.model.WardrobeUser;
import scaa.wardrobe.repository.WardrobeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class WardrobeService implements WardrobeServiceInterface {

    @Autowired
    WardrobeRepository wardrobeRepository;

    @Override
    public void saveClothing(Cloth cloth) {
        //null check cant use equals because left side already null so its nolonger an object
        if (cloth.getClothNumber() == null) {
            cloth.setClothNumber(GenerateClothNumber.generateRandomString(6));
        }
        wardrobeRepository.save(cloth);
        EmailService.sendEmail(new WardrobeUser(1,"scavia","scavia@psybergate.co.za"), new EmailType());
    }

    @Override
    public List<Cloth> search(String keyword) {
        return wardrobeRepository.search(keyword);
    }

    @Override
    public List<Cloth> viewAll() {
        return (List<Cloth>) wardrobeRepository.findAll();
    }

    @Override
    public Cloth getCloth(Long id) {
        return wardrobeRepository.findById(id).get();
    }

    @Override
    public List<Cloth> getWearCombination() {
        List<Cloth> topwear = wardrobeRepository.topWear();
        Collections.shuffle(topwear);
        List<Cloth> bottomwear = wardrobeRepository.bottomWear();
        Collections.shuffle(bottomwear);
        List<Cloth> combination = new ArrayList<>();
        combination.add(topwear.get(0));
        combination.add(bottomwear.get(0));

        return combination;
    }

}
