package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity;

import pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String name;
    private Date lastUpdate;

}
