package scaa.wardrobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import scaa.wardrobe.model.Cloth;
import scaa.wardrobe.service.WardrobeServiceInterface;

import javax.validation.Valid;
import java.util.List;

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

    // TODO add dto
    @PostMapping(value = "/savecloth")
    public String saveClothing(@ModelAttribute("cloth") @Valid Cloth cloth, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/addnew";
        }
        System.out.println("in wardrobecontroller");
        System.out.println(cloth.toString());
        wardrobeServiceInterface.saveClothing(cloth);

        return "/success";
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Cloth> searchlist = wardrobeServiceInterface.search(keyword);
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("searchlist", searchlist);

        return modelAndView;
    }

    @GetMapping(value = "/viewall")
    public ModelAndView viewAll() {
        List<Cloth> viewall = wardrobeServiceInterface.viewAll();
        ModelAndView modelAndView = new ModelAndView("wardrobeitems");
        modelAndView.addObject("viewall", viewall);

        return modelAndView;
    }

    @GetMapping(value = "/edit")
    public ModelAndView editclothing(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("editcustomer");
        Cloth cloth = wardrobeServiceInterface.getCloth(id);
        modelAndView.addObject("cloth", cloth);

        return modelAndView;
    }

    @GetMapping(value = "/todaycombination")
    public ModelAndView todayCombination() {
        List<Cloth> combinationWear = wardrobeServiceInterface.getWearCombination();
        ModelAndView modelAndView = new ModelAndView("combination");
        modelAndView.addObject("combinationWear", combinationWear);

        return modelAndView;
    }

    @GetMapping(value="/reports")
    public String generateReport(){

        return "/reports";
    }

    @GetMapping(value = "/saveinspection")
    public String saveInspection(){

        return "/inspection";
    }
}
