package scaa.wardrobe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import scaa.wardrobe.model.Cloth;

@Controller
@RequestMapping(path = "/")
public class WardrobeController {

    @GetMapping(path = "/")
    public ModelAndView homePage() {
        return new ModelAndView("index");
    }

    @GetMapping(value = "/add")
    public String addClothing(Model model) {
        model.addAttribute("wardrobe", new Cloth());
        return "/addnew";
    }

    @GetMapping(value = "/clothes")
    public ModelAndView clothesMenu() {
        return new ModelAndView("clothes");
    }
}
