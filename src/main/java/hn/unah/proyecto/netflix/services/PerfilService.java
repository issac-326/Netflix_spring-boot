package hn.unah.proyecto.netflix.services;

import java.util.List;
import java.util.Optional;

import hn.unah.proyecto.netflix.models.Perfil;

public interface PerfilService {

    public Optional<Perfil> ingresarAlPerfil(int idPerfil);

    public Optional<Perfil> contadorActivo(int idPerfil, int idUsuario);

    public List<Perfil> retornarPerfiles(int idUsuario);

    public Perfil crearPerfil(Perfil perfil, int idUsuario);

    public Perfil actualizarPerfil(Perfil perfilModificado, int idPerfil);

    public String eliminarPerfil(int idPerfil);
}
