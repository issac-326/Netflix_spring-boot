package hn.unah.proyecto.netflix.models;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfiles")
@Getter
@Setter
@NoArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperfil")
    private int idPerfil;

    private String nombre;
    private String imagen;
    private boolean estado;
    private String contraseniaperfil;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    private Usuario usuarioP;

    // RELACION VER MAS TARDE

    // @OneToOne(mappedBy = "perfil")
    // private VerMastarde verMastarde;
    //// relacion seguir viendo

    // lista de las peliculas para ver mas tarde
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    /*
     * aqui creamos la tabla que guardara las relaciones, colocamos el nombre y
     * posterior mete el nombre de cada columna
     */
    @JoinTable(name = "vermastarde", joinColumns = @JoinColumn(name = "idperfil", referencedColumnName = "idperfil"), inverseJoinColumns = @JoinColumn(name = "idpeliculas", referencedColumnName = "idpeliculas"))
    private List<Pelicula> verMasTarde;

    // lista de la peliculas para continuar viendo
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    /*
     * aqui creamos la tabla que guardara las relaciones, colocamos el nombre y
     * posterior mete el nombre de cada columna
     */
    @JoinTable(name = "seguirviendo", joinColumns = @JoinColumn(name = "idperfil", referencedColumnName = "idperfil"), inverseJoinColumns = @JoinColumn(name = "idpeliculas", referencedColumnName = "idpeliculas"))
    private List<Pelicula> seguirViendo;

    @JsonIgnore
    @ManyToMany(mappedBy = "visto")
    private List<Pelicula> peliculasVistas;

    public boolean getEstado() {
        return estado;
    }

}
