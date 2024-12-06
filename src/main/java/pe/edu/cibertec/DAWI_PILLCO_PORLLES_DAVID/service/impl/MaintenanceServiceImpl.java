package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto.FilmDto;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto.FilmRecordDto;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto.LanguageDto;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity.Film;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity.Language;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.repository.FilmRepository;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.repository.LanguageRepository;
import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<FilmDto> findAllFilms() {

        List<FilmDto> films = new ArrayList<FilmDto>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalDuration(),
                    film.getRentalRate());
            films.add(filmDto);
        });
        return films;

    }

    @Override
    public FilmDetailDto findFilmById(int id) {

        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(film -> new FilmDetailDto(film.getFilmId(),
                film.getTitle(),
                film.getDescription(),
                film.getReleaseYear(),
                film.getLanguage().getLanguageId(),
                film.getLanguage().getName(),
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getLength(),
                film.getReplacementCost(),
                film.getRating(),
                film.getSpecialFeatures(),
                film.getLastUpdate())
        ).orElse(null);

    }

    @Override
    public Boolean updateFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        return optional.map(
                film -> {
                    film.setTitle(filmDetailDto.title());
                    film.setDescription(filmDetailDto.description());
                    film.setReleaseYear(filmDetailDto.releaseYear());
                    film.setRentalDuration(filmDetailDto.rentalDuration());
                    film.setRentalRate(filmDetailDto.rentalRate());
                    film.setLength(filmDetailDto.length());
                    film.setReplacementCost(filmDetailDto.replacementCost());
                    film.setRating(filmDetailDto.rating());
                    film.setSpecialFeatures(filmDetailDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public List<LanguageDto> findAllLanguages() {
        // Obtener todos los idiomas disponibles
        return languageRepository.findAll()
                .stream()
                .map(language -> new LanguageDto(language.getLanguageId(), language.getName()))
                .toList();
    }


    @Override
    public void saveFilm(FilmRecordDto filmRecordDto) {
        Film film;

        // Verificar si es una actualización o un nuevo registro
        if (filmRecordDto.filmId() != null) {
            film = filmRepository.findById(filmRecordDto.filmId())
                    .orElseThrow(() -> new IllegalArgumentException("Film no encontrado"));
        } else {
            film = new Film(); // Creación de un nuevo Film
        }

        // Mapeo del DTO al modelo Film
        film.setTitle(filmRecordDto.title());
        film.setDescription(filmRecordDto.description());
        film.setReleaseYear(filmRecordDto.releaseYear());
        film.setRentalDuration(filmRecordDto.rentalDuration());
        film.setRentalRate(filmRecordDto.rentalRate());
        film.setLength(filmRecordDto.length());
        film.setReplacementCost(filmRecordDto.replacementCost());
        film.setRating(filmRecordDto.rating());
        film.setSpecialFeatures(filmRecordDto.specialFeatures());
        film.setLastUpdate(new Date());

        // Asignar el idioma
        Language language = languageRepository.findById(filmRecordDto.languageId())
                .orElseThrow(() -> new RuntimeException("Idioma no encontrado"));
        film.setLanguage(language);

        // Guardar en la base de datos
        filmRepository.save(film);
    }

    public Optional<Language> findLanguageById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        return languageRepository.findById(id);
    }
    public void deleteFilm(Integer filmId) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film no encontrado"));
        filmRepository.delete(film); // Esto eliminará en cascada las dependencias
    }
    public void removeFilm(Integer id) {
        filmRepository.deleteById(id);  // Elimina la película por su ID
    }

}