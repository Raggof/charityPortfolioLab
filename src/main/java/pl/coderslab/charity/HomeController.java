package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Institution;
import pl.coderslab.repositories.InstitutionRepository;

import java.util.List;

@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;

    public HomeController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        List<String> institTitle = institutionRepository.findAllInstitutionsTitle();
        model.addAttribute("institTitle", institTitle);
        List<String> institDesc = institutionRepository.findAllInstitutionsDesc();
        model.addAttribute("institDest", institDesc);

        return "index";
    }


}
