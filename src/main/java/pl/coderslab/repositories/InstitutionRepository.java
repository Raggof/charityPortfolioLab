package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Institution;

import java.util.List;

@Repository
public interface InstitutionRepository  extends JpaRepository <Institution, Long> {

    @Query(value = "SELECT i.name FROM Institution i ")
    List<String> findAllInstitutionsTitle();

    @Query(value = "SELECT i.description FROM Institution i ")
    List<String> findAllInstitutionsDesc();
}
