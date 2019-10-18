package scaa.wardrobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import scaa.wardrobe.model.WardrobeUser;
import scaa.wardrobe.service.WardrobeUserServiceInterface;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class WardrobeUserController implements WardrobeUserControllerInterface {

    @Autowired
    WardrobeUserServiceInterface wardrobeUserServiceInterface;

    @GetMapping(value = "/add")
    public String addClothing(Model model) {
        model.addAttribute("user", new WardrobeUser());

        return "/addnewuser";
    }

    @PostMapping(value = "/saveuser")
    public String createUser(@ModelAttribute("user") @Valid WardrobeUser wardrobeUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/addnewuser";
        }
        wardrobeUserServiceInterface.createUser(wardrobeUser);
        System.out.println(wardrobeUser.toString());
        return "/index";
    }
}
