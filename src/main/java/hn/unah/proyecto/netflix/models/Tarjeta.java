package hn.unah.proyecto.netflix.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tarjetas")

@NoArgsConstructor
public class Tarjeta {
    
    @Id
    @Column(name = "numerotarjeta")
    private int numeroTarjeta;

    private int cvv;

    @Column(name = "fechavencimiento")
    private Date fechaVencimiento;

    @Column(name = "tipotarjeta")
    private String tipoTarjeta;

	@JsonIgnore
    @OneToOne(mappedBy ="tarjeta")
    private Usuario usuario;
    
}
