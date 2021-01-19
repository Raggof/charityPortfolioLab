package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category, Long> {

}
