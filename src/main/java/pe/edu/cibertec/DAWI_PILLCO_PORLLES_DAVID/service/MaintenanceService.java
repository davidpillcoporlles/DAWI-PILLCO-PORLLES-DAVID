package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.service;

import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto.FilmDto;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto.FilmRecordDto;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto.LanguageDto;

import java.util.List;

public interface MaintenanceService {

    void removeFilm(Integer id);


    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    List<LanguageDto> findAllLanguages();
    void saveFilm(FilmRecordDto filmRecordDto);

    void deleteFilm(Integer filmId);
}
