package hn.unah.proyecto.netflix.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.models.Categoria;
import hn.unah.proyecto.netflix.models.Pelicula;
import hn.unah.proyecto.netflix.models.Perfil;
import hn.unah.proyecto.netflix.repositorys.CategoriaRepository;
import hn.unah.proyecto.netflix.repositorys.PeliculaRepository;
import hn.unah.proyecto.netflix.repositorys.PerfilRepository;
import hn.unah.proyecto.netflix.services.PeliculaService;

@Service
public class PeliculaImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepositorio;

    @Autowired
    private CategoriaRepository categoriaRepositorio;

    @Autowired
    private PerfilRepository perfilRepositorio;

    @Override
    public List<Pelicula> obtenerPeliculas() {

        Iterable<Pelicula> peliculas = peliculaRepositorio.findAll();
        List<Pelicula> listPeliculas = new ArrayList<>();

        peliculas.forEach(listPeliculas::add);

        return listPeliculas;
    }

    @Override
    public List<Pelicula> buscarPorCategoria(int idCategoria) {

        // busco la categoria
        Optional<Categoria> categoria = categoriaRepositorio.findById(idCategoria);
        // obtengo todas las peliculas de esa categoria
        List<Pelicula> peliculas = peliculaRepositorio.findByCategoria(categoria.get());

        return peliculas;
    }

    @Override
    public Optional<Pelicula> buscarPeliculas(String nombre) {

        Optional<Pelicula> pelicula = peliculaRepositorio.findByTitulo(nombre);

        return pelicula;
    }

    @Override
    public String guardarLike(int idPerfil, int idPelicula) {
        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);
        Optional<Pelicula> pelicula = peliculaRepositorio.findById(idPelicula);

        if (perfil.isEmpty()) {
            // no lo encontro xd
            return "No se encontro perfil";
        }
        if (pelicula.isEmpty()) {
            // no lo encontro xd
            return "No se encontro pelicula";
        }
        if (perfil.get().getPeliculaslikes().contains(pelicula.get())) {
            return "Ya tiene tu like";
        }
        perfil.get().getPeliculaslikes().add(pelicula.get());
        perfilRepositorio.save(perfil.get());
        return "se agrego un like";
    }

    @Override
    public String eliminarLike(int idPerfil, int idPelicula) {
        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);
        Optional<Pelicula> pelicula = peliculaRepositorio.findById(idPelicula);
        if (perfil.isEmpty()) {
            // no lo encontro xd
            return "No se encontro perfil";
        }
        if (pelicula.isEmpty()) {
            // no lo encontro xd
            return "No se encontro pelicula";
        }
        if (!perfil.get().getPeliculaslikes().contains(pelicula.get())) {
            return "Like no encontrado";
        }
        perfil.get().getPeliculaslikes().remove(pelicula.get());
        perfilRepositorio.save(perfil.get());
        return "se elimino el like";
    }

}
