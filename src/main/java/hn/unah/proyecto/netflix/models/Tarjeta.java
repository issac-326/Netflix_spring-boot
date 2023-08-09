package hn.unah.proyecto.netflix.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
