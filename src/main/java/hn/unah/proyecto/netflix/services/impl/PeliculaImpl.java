package hn.unah.proyecto.netflix.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.models.Categoria;
import hn.unah.proyecto.netflix.models.Pelicula;
import hn.unah.proyecto.netflix.repositorys.CategoriaRepository;
import hn.unah.proyecto.netflix.repositorys.PeliculaRepository;
import hn.unah.proyecto.netflix.services.PeliculaService;

@Service
public class PeliculaImpl implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepositorio;

    @Autowired
    private CategoriaRepository categoriaRepositorio;

    @Override
    public List<Pelicula> obtenerPeliculas() {
        
        Iterable<Pelicula> peliculas = peliculaRepositorio.findAll();
        List<Pelicula> listPeliculas = new ArrayList<>();

        peliculas.forEach(listPeliculas::add);

        return listPeliculas;
    }

    @Override
    public List<Pelicula> buscarPorCategoria(int idCategoria) {
        
        //busco la categoria
        Optional<Categoria> categoria = categoriaRepositorio.findById(idCategoria);
        //obtengo todas las peliculas de esa categoria
        List<Pelicula> peliculas = peliculaRepositorio.findByCategoria(categoria.get());

        return peliculas;
    }

    @Override
    public Optional<Pelicula> buscarPeliculas(String nombre) {
        
        Optional<Pelicula> pelicula = peliculaRepositorio.findByTitulo(nombre);

        return pelicula;
    }
    
}
