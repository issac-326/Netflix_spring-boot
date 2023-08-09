package hn.unah.proyecto.netflix.repositorys;

import org.springframework.data.repository.CrudRepository;

import hn.unah.proyecto.netflix.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    
}
