package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Institution;
import pl.coderslab.repositories.DonationRepository;
import pl.coderslab.repositories.InstitutionRepository;

import java.util.List;

@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository,DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institList = institutionRepository.findAll();
        model.addAttribute("institList", institList);
        int sackQuan =  donationRepository.sumOfQuantity();
        model.addAttribute("sackQuan", sackQuan);
        int countDonat =  donationRepository.sumOfDonations();
        model.addAttribute("countDonat", countDonat);
        return "index";
    }


}
