package hn.unah.proyecto.netflix.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.proyecto.netflix.models.Pelicula;
import hn.unah.proyecto.netflix.services.impl.PeliculaImpl;

@RestController
@RequestMapping("/api/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaImpl peliculaImplementacion;

    @GetMapping("/todas")
    public List<Pelicula> obtenerPeliculas() {
        return peliculaImplementacion.obtenerPeliculas();
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<Pelicula> buscarPorCategoria(@PathVariable int idCategoria) {
        return peliculaImplementacion.buscarPorCategoria(idCategoria);
    }

    @GetMapping("/buscar/titulo/{nombre}")
    public Optional<Pelicula> buscarPeliculas(@PathVariable String nombre) {
        return peliculaImplementacion.buscarPeliculas(nombre);
    }

    @PostMapping("/guardarLike/{idPerfil}/{idPelicula}")
    public String guardarLike(@PathVariable int idPerfil, @PathVariable int idPelicula) {
        return peliculaImplementacion.guardarLike(idPerfil, idPelicula);
    }

    @GetMapping("/eliminarLike/{idPerfil}/{idPelicula}")
    public String eliminarLike(@PathVariable int idPerfil, @PathVariable int idPelicula) {
        return peliculaImplementacion.eliminarLike(idPerfil, idPelicula);
    }

    @GetMapping("/Like/{idPelicula}")
    public int like(@PathVariable int idPelicula) {
        return peliculaImplementacion.like(idPelicula);
    }

    @PostMapping("/peliculavista/{idPerfil}/{idPelicula}")
    public String peliculaVista(@PathVariable int idPerfil, @PathVariable int idPelicula) {
        return peliculaImplementacion.peliculaVista(idPerfil, idPelicula);
    }

    @GetMapping("/popularidad/{idPelicula}")
    public int popularidad(@PathVariable int idPelicula) {
        return peliculaImplementacion.popularidad(idPelicula);
    }

    @GetMapping("/reciente")
    public Pelicula peliculaReciente(){
        return peliculaImplementacion.peliculaReciente();
    }
}
