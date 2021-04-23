package pl.coderslab.services;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Donation;
import pl.coderslab.repositories.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public String sumOfQuantity() {
        return donationRepository.sumOfQuantity();
    }

    @Override
    public long count() {
        return donationRepository.count();
    }

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }


}
