package hn.unah.proyecto.netflix.repositorys;

import org.springframework.data.repository.CrudRepository;

import hn.unah.proyecto.netflix.models.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Integer> {
    
}
