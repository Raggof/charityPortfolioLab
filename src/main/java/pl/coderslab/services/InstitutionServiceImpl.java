package pl.coderslab.services;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Institution;
import pl.coderslab.repositories.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAllInstitution() {
        return institutionRepository.findAll();
    }
}
