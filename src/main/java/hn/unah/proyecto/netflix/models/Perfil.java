package hn.unah.proyecto.netflix.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    //@OneToOne(mappedBy = "perfil")
    //private VerMastarde verMastarde;
    //// relacion seguir viendo

    @OneToMany(mappedBy = "perfilTarde")
    private List<Pelicula> verMasTarde; 

    @OneToOne(mappedBy = "perfil")
    private SeguirViendo seguirViendo;


    public boolean getEstado() {
        return estado;
    }

}
