package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class FilmActorId implements Serializable {
    private Integer filmId;
    private Integer actorId;

    // Constructor vacío
    public FilmActorId() {}

    // Constructor con parámetros
    public FilmActorId(Integer filmId, Integer actorId) {
        this.filmId = filmId;
        this.actorId = actorId;
    }

    // Getters y Setters
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(filmId, that.filmId) &&
                Objects.equals(actorId, that.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, actorId);
    }
}
