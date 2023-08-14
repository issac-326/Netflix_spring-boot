package hn.unah.proyecto.netflix.services;

import java.util.List;
import java.util.Optional;

import hn.unah.proyecto.netflix.models.Pelicula;

public interface PeliculaService {

    public List<Pelicula> obtenerPeliculas();

    public List<Pelicula> buscarPorCategoria(int idcategoria);

    public Optional<Pelicula> buscarPeliculas(String nombre);

    public String guardarLike(int idPerfil, int idPelicula);

    public String eliminarLike(int idPerfil, int idPelicula);
}
