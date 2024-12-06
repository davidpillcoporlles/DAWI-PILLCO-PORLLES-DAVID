package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto;

import java.util.Date;

public record FilmDto(Integer filmId,
                      String title,
                      String language,
                      Integer rentalDuration,
                      Double rentalRate) {

}
