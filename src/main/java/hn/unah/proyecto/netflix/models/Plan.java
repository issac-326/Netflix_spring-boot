package hn.unah.proyecto.netflix.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplan")
    private int idPlan;

    private String descripcion;

    @Column(name = "costomensual")
    private double costoMensual;

    @Column(name = "cantidadperfiles")
    private int cantidadPerfiles;

    @Column(name = "nombreplan")
    private String nombrePlan;
    @JsonIgnore
    
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    private List<Usuario> usuario;
}
