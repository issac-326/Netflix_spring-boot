package hn.unah.proyecto.netflix.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hn.unah.proyecto.netflix.models.Categoria;
import hn.unah.proyecto.netflix.models.Pelicula;
import hn.unah.proyecto.netflix.models.Usuario;


public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
    
    Optional<Usuario> findByCorreo(String correo);
    List<Pelicula> findByCategoria(Categoria categoria);
}
