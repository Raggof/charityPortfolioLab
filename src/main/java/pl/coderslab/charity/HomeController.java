package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Institution;
import pl.coderslab.repositories.DonationRepository;
import pl.coderslab.repositories.InstitutionRepository;

import javax.validation.constraints.Null;
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
    public String homeAction(Model model) {
        List<Institution> institList = institutionRepository.findAll();
        model.addAttribute("institList", institList);
        String sackQuan = donationRepository.sumOfQuantity();
        model.addAttribute("sackQuan", checkNullQuan(sackQuan));
        long countDonat = donationRepository.count();
        model.addAttribute("countDonat", checkCount(countDonat));
        return "index";
    }

    public int checkNullQuan(String sackQuan){
        if (sackQuan==null){
            return 0;
        } else {
            return Integer.parseInt(sackQuan);
        }
    }

    public long checkCount(long countDon){
        if (countDon==0){
            return 0;
        } else {
            return countDon;
        }
    }

}
