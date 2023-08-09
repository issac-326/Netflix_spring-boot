package hn.unah.proyecto.netflix.repositorys;

import org.springframework.data.repository.CrudRepository;

import hn.unah.proyecto.netflix.models.Pelicula;

public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
    
}
