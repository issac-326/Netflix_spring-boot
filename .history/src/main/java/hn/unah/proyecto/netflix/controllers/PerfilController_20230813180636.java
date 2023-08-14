package hn.unah.proyecto.netflix.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.proyecto.netflix.models.Pelicula;
import hn.unah.proyecto.netflix.models.Perfil;
import hn.unah.proyecto.netflix.services.impl.PerfilImpl;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController {

    @Autowired
    private PerfilImpl perfilImplementacion;

    @GetMapping("/perfiles/{idUsuario}")
    public List<Perfil> retornarPerfiles(@PathVariable int idUsuario) {
        return perfilImplementacion.retornarPerfiles(idUsuario);
    }

    @GetMapping("/cambiar/estado/{idPerfil}")
    public Optional<Perfil> ingresarAlPerfil(@PathVariable int idPerfil) {
        return perfilImplementacion.ingresarAlPerfil(idPerfil);
    }

    @GetMapping("/{id}")
    public Optional<Perfil> obtenerPerfil(@PathVariable int id) {
        return perfilImplementacion.obtenerPerfil(id);
    }

    // crea un perfil
    @PostMapping("/crear/{idUsuario}")
    public Perfil crearPerfil(@RequestBody Perfil perfil, @PathVariable int idUsuario) {
        return perfilImplementacion.crearPerfil(perfil, idUsuario);
    }

    @PostMapping("/actualizar")
    public Perfil modificarPerfil(@RequestBody Perfil perfil) {
        return perfilImplementacion.actualizaPerfil(perfil);
    }

    @GetMapping("/eliminar/{idPerfil}")
    public String eliminarPerfil(@PathVariable int idPerfil) {
        return perfilImplementacion.eliminarPerfil(idPerfil);
    }

    @GetMapping("/vermastarde/{idPerfil}")
    public List<Pelicula> verMasTarde(@PathVariable int idPerfil) {
        return perfilImplementacion.verMasTarde(idPerfil);
    }

    @GetMapping("/seguirViendo/{idPerfil}")
    public List<Pelicula> seguirViendo(@PathVariable int idPerfil) {
        return perfilImplementacion.seguirViendo(idPerfil);
    }

    @PostMapping("/guardarSeguirViendo/{idPerfil}/{idPelicula}")
    public String guardarSeguirViendo(@PathVariable int idPerfil, @PathVariable int idPelicula) {
        return perfilImplementacion.guardarSeguirViendo(idPerfil, idPelicula);
    }

    @PostMapping("/guardarVerMasTarde/{idPerfil}/{idPelicula}")
    public String guardarVerMasTarde(@PathVariable int idPerfil, @PathVariable int idPelicula) {
        return perfilImplementacion.guardarVerMasTarde(idPerfil, idPelicula);
    }

    @PostMapping("/eliminarSeguirViendo/{idPerfil}/{idPelicula}")
    public String eliminarSeguirViendo(@PathVariable int idPerfil, @PathVariable int idPelicula) {
        return perfilImplementacion.eliminarSeguirViendo(idPerfil, idPelicula);
    }

    @PostMapping("/eliminarVerMasTarde/{idPerfil}/{idPelicula}")
    public String eliminarVerMasTarde(@PathVariable int idPerfil, @PathVariable int idPelicula) {
        return perfilImplementacion.eliminarVerMasTarde(idPerfil, idPelicula);
    }
}
