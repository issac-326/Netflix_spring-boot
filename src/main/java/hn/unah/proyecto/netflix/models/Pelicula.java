package hn.unah.proyecto.netflix.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "peliculas")
@Setter
@Getter
@NoArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpeliculas")
    private int idPeliculas;

    private String titulo;

    private String descripcion;

    private String calificacion;

    private String duracion;

    private String imagen;
    private int aniolanzamiento;

    @ManyToOne()
    @JoinColumn(name = "idcategorias", referencedColumnName = "idcategorias")
    private Categoria categoria;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaagregada")
    private Date fechaAgregada;

    // @JsonIgnore
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "idvermastarde", referencedColumnName = "idvermastarde")
    // private VerMastarde verTarde;

    // relacion con la lista de ver mas tarde
    @JsonIgnore
    @ManyToMany(mappedBy = "verMasTarde")
    private List<Perfil> perfilMasTarde;

    // relacion con la lista de seguir viendo
    @JsonIgnore
    @ManyToMany(mappedBy = "seguirViendo")
    private List<Perfil> perfilSeguirViendo;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "perfilpeliculasvistas", joinColumns = @JoinColumn(name = "idpeliculas", referencedColumnName = "idpeliculas"), inverseJoinColumns = @JoinColumn(name = "idperfil", referencedColumnName = "idperfil"))
    private List<Perfil> visto;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "likes", joinColumns = @JoinColumn(name = "idpeliculas", referencedColumnName = "idpeliculas"), inverseJoinColumns = @JoinColumn(name = "idperfil", referencedColumnName = "idperfil"))
    private List<Perfil> likes;

}
