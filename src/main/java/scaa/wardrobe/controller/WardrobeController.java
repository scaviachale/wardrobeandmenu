package scaa.wardrobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import scaa.wardrobe.model.Cloth;
import scaa.wardrobe.service.WardrobeServiceInterface;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/")
public class WardrobeController implements WardrobeControllerInterface {

    @Autowired
    WardrobeServiceInterface wardrobeServiceInterface;

    @GetMapping(path = "/")
    public ModelAndView homePage() {
        return new ModelAndView("index");
    }

    @GetMapping(value = "/add")
    public String addClothing(Model model) {
        model.addAttribute("cloth", new Cloth());
        return "/addnew";
    }

    @GetMapping(value = "/clothes")
    public ModelAndView clothesMenu() {
        return new ModelAndView("clothes");
    }

    @PostMapping(value = "/savecloth")
    public String saveClothing(@ModelAttribute("cloth") @Valid Cloth cloth, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("++++++has errors++++++");
            return "/addnew";
        }
        System.out.println(cloth.toString());
        wardrobeServiceInterface.saveClothing(cloth);
        return "redirect:/success";
    }
}
