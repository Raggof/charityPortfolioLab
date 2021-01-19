package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Donation;
import pl.coderslab.entity.Institution;
import pl.coderslab.repositories.CategoryRepository;
import pl.coderslab.repositories.DonationRepository;
import pl.coderslab.repositories.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;


@Controller
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/form")
    public String formAction(Model model){
        List<Category> catList = categoryRepository.findAll();
        model.addAttribute("categories", catList);
        List<Institution> instList = institutionRepository.findAll();
        model.addAttribute("institutions", instList);
        model.addAttribute("donation", new Donation());
        return "form/form1";
    }

    @RequestMapping("/thankyou")
    public String thanksPage(){
        return "form/thankYou";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String saveDentist(@Valid Donation donation, BindingResult result, Model model) {

        List<Category> catList = categoryRepository.findAll();
        model.addAttribute("categories", catList);
        List<Institution> instList = institutionRepository.findAll();
        model.addAttribute("institutions", instList);
        if (result.hasErrors()) {
            return "form/form1";
        }
        donationRepository.save(donation);
        return "redirect:/thankyou";
    }

}
