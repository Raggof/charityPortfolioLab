package pl.coderslab.services;

import pl.coderslab.entity.Donation;

public interface DonationService {

    String sumOfQuantity();

    long count();

    void save(Donation donation);
}
