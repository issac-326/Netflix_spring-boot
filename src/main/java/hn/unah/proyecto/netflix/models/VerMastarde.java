package hn.unah.proyecto.netflix.models;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VerMastarde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvermastarde")
    private int idVerMasTarde;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil")
    private Perfil perfil;

    @OneToMany(mappedBy = "verTarde")
    private List<Pelicula> peliculas;
}
