package hn.unah.proyecto.netflix.services;

import java.util.List;

import hn.unah.proyecto.netflix.models.Pelicula;

public interface PeliculaService {
    
    public List<Pelicula> obtenerPeliculas();

    public List<Pelicula> buscarPorCategoria(int idcategoria);
}
