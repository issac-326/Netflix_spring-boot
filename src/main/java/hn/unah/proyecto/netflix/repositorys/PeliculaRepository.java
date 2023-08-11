package hn.unah.proyecto.netflix.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.proyecto.netflix.models.Categoria;
import hn.unah.proyecto.netflix.models.Pelicula;


public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    
    List<Pelicula> findByCategoria(Categoria categoria);
}
