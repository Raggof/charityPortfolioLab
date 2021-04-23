package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Donation;
import pl.coderslab.entity.Institution;
import pl.coderslab.services.CategoryService;
import pl.coderslab.services.DonationService;
import pl.coderslab.services.InstitutionService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/form")
    public String formAction(Model model){
        List<Category> catList = categoryService.findAllCategory();
        model.addAttribute("categories", catList);
        List<Institution> instList = institutionService.findAllInstitution();
        model.addAttribute("institutions", instList);

        model.addAttribute("donation", new Donation());
        return "form/form";
    }

    @RequestMapping("/thankyou")
    public String thanksPage(){
        return "form/thankYou";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String saveDonation(@Valid Donation donation, BindingResult result, Model model) {
        List<Category> catList = categoryService.findAllCategory();
        model.addAttribute("categories", catList);
        List<Institution> instList = institutionService.findAllInstitution();
        model.addAttribute("institutions", instList);

        if (result.hasErrors()) {
            return "form/form";
        }
        donationService.save(donation);
        return "redirect:/thankyou";
    }

}
