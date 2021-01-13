package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Donation;
import pl.coderslab.entity.Institution;
import pl.coderslab.repositories.CategoryRepository;
import pl.coderslab.repositories.InstitutionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/form")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping("")
    public String formAction(Model model){
        List<Category> catList = categoryRepository.findAll();
        model.addAttribute("categories", catList);
        List<Institution> instList = institutionRepository.findAll();
        model.addAttribute("institutions", instList);
        model.addAttribute("donation", new Donation());
        return "form/form1";
    }


}
