package hn.unah.proyecto.netflix.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.models.Pelicula;
import hn.unah.proyecto.netflix.repositorys.PeliculaRepository;
import hn.unah.proyecto.netflix.services.PeliculaService;

@Service
public class PeliculaImpl implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepositorio;

    @Override
    public List<Pelicula> obtenerPeliculas() {
        
        Iterable<Pelicula> peliculas = peliculaRepositorio.findAll();
        List<Pelicula> listPeliculas = new ArrayList<>();

        peliculas.forEach(listPeliculas::add);

        return listPeliculas;
    }
    
}
