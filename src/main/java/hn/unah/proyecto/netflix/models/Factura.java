package hn.unah.proyecto.netflix.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactura")
    private int idFactura;

    @Column(name = "montototal")
    private double montoTotal;

    @Column(name= "fechaemision")
    private Date fechaEmision;

    private String descripcion;

    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idusuario", referencedColumnName="idusuario")
	private Usuario usuarioF;
}
