package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Institution;
import pl.coderslab.services.DonationService;
import pl.coderslab.services.InstitutionService;

import java.util.List;

@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService,DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        List<Institution> institList = institutionService.findAllInstitution();
        model.addAttribute("institList", institList);
        String sackQuan = donationService.sumOfQuantity();
        model.addAttribute("sackQuan", checkNullQuan(sackQuan));
        long countDonat = donationService.count();
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
