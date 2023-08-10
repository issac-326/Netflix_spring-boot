package hn.unah.proyecto.netflix.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellido;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecharegistro")
    private Date fechaRegistro;

    // relacion de usuario/facturas de 1:M
    @OneToMany(mappedBy = "usuarioF")
    private List<Factura> facturas;

    // relacion de usuario/perfiles de 1:M
    @OneToMany(mappedBy = "usuarioP")
    private List<Perfil> perfiles;
    // relacion de usuario/tarjeta 1:1
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numerotarjeta", referencedColumnName = "numerotarjeta")
    private Tarjeta tarjeta;

    // relacion de usuario/plan
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idplan", referencedColumnName = "idplan")
    private Plan plan;

}
