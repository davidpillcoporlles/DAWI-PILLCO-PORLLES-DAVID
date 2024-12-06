package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public record FilmRecordDto(
        Integer filmId,
        String title,
        String description,
        Integer releaseYear,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures,
        Integer languageId,
        @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastUpdate
) {
    public static FilmRecordDto empty() {
        return new FilmRecordDto(null, "", "", null, null, null, null, null, "", "", null, null);
    }
}


