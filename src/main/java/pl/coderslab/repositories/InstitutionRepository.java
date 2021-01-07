package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Institution;

import java.util.List;

@Repository
public interface InstitutionRepository  extends JpaRepository <Institution, Long> {


}
