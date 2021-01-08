package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) as sum_quan from donations", nativeQuery = true)
    int sumOfQuantity();

    @Query(value = "SELECT COUNT(id) FROM donations",nativeQuery = true)
    int sumOfDonations();
}
