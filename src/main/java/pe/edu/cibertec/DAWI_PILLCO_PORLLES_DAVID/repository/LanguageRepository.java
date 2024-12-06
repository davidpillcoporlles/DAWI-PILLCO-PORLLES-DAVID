package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository extends CrudRepository<Language, Integer> {

    List<Language> findAll();
}
