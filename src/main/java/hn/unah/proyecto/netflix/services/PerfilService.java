package hn.unah.proyecto.netflix.services;

import java.util.List;
import java.util.Optional;

import hn.unah.proyecto.netflix.models.Pelicula;
import hn.unah.proyecto.netflix.models.Perfil;

public interface PerfilService {

    public Optional<Perfil> ingresarAlPerfil(int idPerfil);

    public Optional<Perfil> contadorActivo(int idPerfil, int idUsuario);

    public List<Perfil> retornarPerfiles(int idUsuario);

    public Optional<Perfil> crearPerfil(Perfil perfil, int idUsuario);

    public Optional<Perfil> obtenerPerfil(int id);

    public Perfil actualizaPerfil(Perfil perfil);

    public String eliminarPerfil(int idPerfil);

    public List<Pelicula> seguirViendo(int idPerfil);

    public List<Pelicula> verMasTarde(int idPerfil);

    public String guardarSeguirViendo(int idPerfil, int idPelicula);

    public String guardarVerMasTarde(int idPerfil, int idPelicula);

    public String eliminarSeguirViendo(int idPerfil, int idPelicula);

    public String eliminarVerMasTarde(int idPerfil, int idPelicula);

}
