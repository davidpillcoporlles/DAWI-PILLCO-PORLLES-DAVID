package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity.Film;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity.Language;

import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Integer> {



}
