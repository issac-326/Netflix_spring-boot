package hn.unah.proyecto.netflix.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "planes")
@Getter
@Setter
@NoArgsConstructor
public class Plan {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idplan")
    private int idPlan;

    private String descripcion;
    
    @Column(name = "costomensual")
    private double costoMensual;

    @Column(name = "cantidadperfiles")
    private int cantidadPerfiles;
}
