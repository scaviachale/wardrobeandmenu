package scaa.wardrobe.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import scaa.wardrobe.model.cloth.Cloth;

@RestController
public class WardrobeController {

    @GetMapping(path = "/")
    public ModelAndView homePage() {

        return new ModelAndView("index");
    }

    @GetMapping(value="/add")
    public String addClothing(Model model) {
        model.addAttribute("wardrobe",new Cloth());
        return "addcloth";
    }
}
